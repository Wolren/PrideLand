package net.wolren.land.screen;

import com.google.common.collect.Lists;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.inventory.*;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.Level;
import net.wolren.land.LandCommon;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;

import java.util.List;

public class RainbowCraftingScreenHandler extends AbstractContainerMenu {
    final Slot dyeSlot;
    final Slot inputSlot;
    final Slot outputSlot;
    private final DataSlot selectedRecipe = DataSlot.standalone();
    private final Level world;
    private List<RainbowCuttingRecipe> availableRecipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    private ItemStack dyeStack = ItemStack.EMPTY;

    Runnable contentsChangedListener = () -> {
    };

    public final Container input = new SimpleContainer(2) {
        public void setChanged() {
            super.setChanged();
            RainbowCraftingScreenHandler.this.slotsChanged(this);
            RainbowCraftingScreenHandler.this.contentsChangedListener.run();
        }
    };

    final ResultContainer output = new ResultContainer();

    public RainbowCraftingScreenHandler(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, new SimpleContainer(3));
    }

    public RainbowCraftingScreenHandler(int syncId, Inventory playerInventory, Container inventory) {
        super(ModScreenHandlers.BOX_SCREEN_HANDLER, syncId);
        this.world = playerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 22));

        this.dyeSlot = this.addSlot(new Slot(this.input, 1, 20, 44) {
            public boolean mayPlace(ItemStack stack) {
                Item item = stack.getItem();
                return item == ModItems.RAINBOW_DYE;
            }
        });

        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                RainbowCraftingScreenHandler.this.output.awardUsedRecipes(player, this.getInputStacks());
                ItemStack materialStack = RainbowCraftingScreenHandler.this.inputSlot.remove(1);
                ItemStack dyeStack = RainbowCraftingScreenHandler.this.dyeSlot.remove(1);
                if (!materialStack.isEmpty() && !(dyeStack.getCount() <= 0)) {
                    RainbowCraftingScreenHandler.this.populateResult();
                }

                super.onTake(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(RainbowCraftingScreenHandler.this.inputSlot.getItem());
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addDataSlot(this.selectedRecipe);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }


    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public List<RainbowCuttingRecipe> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }

        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public void slotsChanged(Container inventory) {
        ItemStack materialStack = this.inputSlot.getItem();
        ItemStack dyeStack = this.dyeSlot.getItem();


        if (!materialStack.is(this.inputStack.getItem())) {
            this.inputStack = materialStack.copy();
            this.updateInput(inventory, materialStack, dyeStack);
        }

        if (!dyeStack.is(this.dyeStack.getItem())) {
            this.dyeStack = dyeStack.copy();
            this.updateInput(inventory, materialStack, dyeStack);
        }
    }


    private void updateInput(Container input, ItemStack materialStack, ItemStack dyeStack) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.outputSlot.setByPlayer(ItemStack.EMPTY);
        if (!materialStack.isEmpty() && !dyeStack.isEmpty()) {
            this.availableRecipes = this.world.getRecipeManager().getRecipesFor(LandCommon.RAINBOW_CUTTING, input, this.world);
        }
    }

    void populateResult() {
        if (!RainbowCraftingScreenHandler.this.dyeSlot.getItem().isEmpty() && !this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RainbowCuttingRecipe rainbowCuttingRecipe = this.availableRecipes.get(this.selectedRecipe.get());
            ItemStack itemStack = rainbowCuttingRecipe.assemble(this.input, this.world.registryAccess());
            if (itemStack.isItemEnabled(this.world.enabledFeatures())) {
                this.output.setRecipeUsed(rainbowCuttingRecipe);
                this.outputSlot.setByPlayer(itemStack);
            } else {
                this.outputSlot.setByPlayer(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.setByPlayer(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.output && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasItem()) {
            ItemStack itemStack2 = slot2.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();

            if (slot == 2) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickCraft(itemStack2, itemStack);
            } else if (slot == 0 || slot == 1) {
                if (!this.moveItemStackTo(itemStack2, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world
                    .getRecipeManager()
                    .getRecipeFor(LandCommon.RAINBOW_CUTTING, new SimpleContainer(itemStack2), this.world)
                    .isPresent()) {
                if (!this.moveItemStackTo(itemStack2, this.inputSlot.index, this.inputSlot.index + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (item == ModItems.RAINBOW_DYE) {
                if (!this.moveItemStackTo(itemStack2, this.dyeSlot.index, this.dyeSlot.index + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 3 && slot < 30) {
                if (!this.moveItemStackTo(itemStack2, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 30 && slot < 39 && !this.moveItemStackTo(itemStack2, 3, 30, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setByPlayer(ItemStack.EMPTY);
            }

            slot2.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTake(player, itemStack2);
            this.broadcastChanges();
        }

        return itemStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.output.removeItemNoUpdate(1);
        this.clearContainer(player, this.input);
    }

    public Slot getDyeSlot() {
        return this.dyeSlot;
    }
}
