package net.wolren.land.screen;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;

import java.util.List;
import java.util.Optional;

/**
 * Rainbow crafting station menu: 2 input slots (material + rainbow dye),
 * 1 output slot, full player inventory. Auto-selects the first matching
 * cutting recipe, stonecutter-style.
 *
 * Uses the 26.2 RecipeAccess.stonecutterRecipes() selectable set (the same
 * mechanism as the vanilla StonecutterMenu) - the set is synced to the client,
 * so no RecipeManager cast is needed and the menu works on both sides.
 */
public class RainbowCraftingScreenHandler extends AbstractContainerMenu {
    private static final int MATERIAL_SLOT_INDEX = 0;
    private static final int DYE_SLOT_INDEX = 1;
    private static final int OUTPUT_SLOT_INDEX = 2;

    private final Slot inputSlot;
    private final Slot dyeSlot;
    private final Slot outputSlot;
    private final DataSlot selectedRecipe = DataSlot.standalone();
    private final Level world;
    private SelectableRecipe.SingleInputSet<StonecutterRecipe> recipesForInput = SelectableRecipe.SingleInputSet.empty();
    private ItemStack inputStack = ItemStack.EMPTY;
    private ItemStack dyeStack = ItemStack.EMPTY;

    public final Container input = new SimpleContainer(2) {
        @Override
        public void setChanged() {
            super.setChanged();
            RainbowCraftingScreenHandler.this.slotsChanged(this);
            RainbowCraftingScreenHandler.this.slotUpdateListener.run();
        }
    };
    private Runnable slotUpdateListener = () -> {};
    private final ResultContainer output = new ResultContainer();

    public RainbowCraftingScreenHandler(int syncId, Inventory inventory) {
        this(syncId, inventory, new SimpleContainer(3));
    }

    public RainbowCraftingScreenHandler(int syncId, Inventory playerInventory, Container ignored) {
        super(ModScreenHandlers.BOX_SCREEN_HANDLER, syncId);
        this.world = playerInventory.player.level();

        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 22));

        this.dyeSlot = this.addSlot(new Slot(this.input, 1, 20, 44) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.RAINBOW_DYE);
            }
        });

        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player, stack.getCount());
                ItemStack material = RainbowCraftingScreenHandler.this.inputSlot.remove(1);
                ItemStack dye = RainbowCraftingScreenHandler.this.dyeSlot.remove(1);
                if (!material.isEmpty() && !dye.isEmpty()) {
                    RainbowCraftingScreenHandler.this.setupResultSlot();
                }
                super.onTake(player, stack);
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addDataSlot(this.selectedRecipe);
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.recipesForInput.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.output.removeItemNoUpdate(1);
        this.clearContainer(player, this.input);
    }

    @Override
    public void slotsChanged(Container inventory) {
        ItemStack materialStack = this.inputSlot.getItem();
        ItemStack dye = this.dyeSlot.getItem();
        if (!materialStack.is(this.inputStack.getItem()) || !dye.is(this.dyeStack.getItem())) {
            this.inputStack = materialStack.copy();
            this.dyeStack = dye.copy();
            this.setupRecipeList(materialStack, dye);
        }
    }

    private void setupRecipeList(ItemStack materialStack, ItemStack dyeStack) {
        this.selectedRecipe.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!materialStack.isEmpty() && !dyeStack.isEmpty()) {
            this.recipesForInput = this.world.recipeAccess().stonecutterRecipes().selectByInput(materialStack);
        } else {
            this.recipesForInput = SelectableRecipe.SingleInputSet.empty();
        }
        this.setupResultSlot();
    }

    private void setupResultSlot() {
        int index = this.selectedRecipe.get();
        if (index >= 0 && index < this.recipesForInput.size()) {
            SelectableRecipe.SingleInputEntry<StonecutterRecipe> entry = this.recipesForInput.entries().get(index);
            Optional<RecipeHolder<StonecutterRecipe>> holderOpt = entry.recipe().recipe();
            if (holderOpt.isPresent()) {
                // Server side: real recipe holder.
                RecipeHolder<StonecutterRecipe> holder = holderOpt.get();
                RainbowCuttingRecipe cutting = (RainbowCuttingRecipe) holder.value();
                ItemStack result = cutting.getResult();
                if (result.isItemEnabled(this.world.enabledFeatures())) {
                    this.output.setRecipeUsed((RecipeHolder<?>) holder);
                    this.outputSlot.set(result);
                } else {
                    this.outputSlot.set(ItemStack.EMPTY);
                }
            } else {
                // Client side: the synced set carries only the SlotDisplay
                // (noRecipeCodec drops the recipe holder). Resolve the visual
                // stack from the display; the server syncs the real result.
                ItemStack result = entry.recipe().optionDisplay()
                        .resolveForFirstStack(net.minecraft.world.item.crafting.display.SlotDisplayContext.fromLevel(this.world));
                if (result.isItemEnabled(this.world.enabledFeatures())) {
                    this.output.setRecipeUsed(null);
                    this.outputSlot.set(result);
                } else {
                    this.outputSlot.set(ItemStack.EMPTY);
                }
            }
        } else {
            this.outputSlot.set(ItemStack.EMPTY);
            this.output.setRecipeUsed(null);
        }
        this.broadcastChanges();
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id >= 0 && id < this.recipesForInput.size()) {
            this.selectedRecipe.set(id);
            this.setupResultSlot();
            return true;
        }
        return false;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack clicked = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            Item item = stack.getItem();
            clicked = stack.copy();
            if (index == OUTPUT_SLOT_INDEX) {
                item.onCraftedBy(stack, player);
                if (!this.moveItemStackTo(stack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, clicked);
            } else if (index == MATERIAL_SLOT_INDEX || index == DYE_SLOT_INDEX) {
                if (!this.moveItemStackTo(stack, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world.recipeAccess().stonecutterRecipes().acceptsInput(stack)) {
                if (!this.moveItemStackTo(stack, MATERIAL_SLOT_INDEX, DYE_SLOT_INDEX, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stack.is(ModItems.RAINBOW_DYE)) {
                if (!this.moveItemStackTo(stack, DYE_SLOT_INDEX, OUTPUT_SLOT_INDEX, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 3 && index < 30) {
                if (!this.moveItemStackTo(stack, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 30 && index < 39) {
                if (!this.moveItemStackTo(stack, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (stack.getCount() == clicked.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
            if (index == OUTPUT_SLOT_INDEX) {
                this.outputSlot.set(ItemStack.EMPTY);
                this.setupResultSlot();
            }

            this.broadcastChanges();
        }

        return clicked;
    }

    public void registerUpdateListener(Runnable slotUpdateListener) {
        this.slotUpdateListener = slotUpdateListener;
    }

    public int getSelectedRecipe() {
        return selectedRecipe.get();
    }

    public SelectableRecipe.SingleInputSet<StonecutterRecipe> getVisibleRecipes() {
        return recipesForInput;
    }

    public Slot getDyeSlot() {
        return dyeSlot;
    }
}
