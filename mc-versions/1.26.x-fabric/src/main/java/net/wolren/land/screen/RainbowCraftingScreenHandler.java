package net.wolren.land.screen;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.wolren.land.PrideLand;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RainbowCraftingScreenHandler extends AbstractContainerMenu {
    private final Slot dyeSlot;
    private final Slot inputSlot;
    private final Slot outputSlot;
    private final Container input = new SimpleContainer(2) {
        public void setChanged() {
            super.setChanged();
            RainbowCraftingScreenHandler.this.slotsChanged(this);
        }
    };
    private final net.minecraft.world.inventory.ResultContainer output = new net.minecraft.world.inventory.ResultContainer();
    private final ContainerLevelAccess access;
    private List<RainbowCuttingRecipe> availableRecipes = java.util.Collections.emptyList();
    private ItemStack inputStack = ItemStack.EMPTY;
    private ItemStack dyeStack = ItemStack.EMPTY;
    private int selectedRecipe = -1;

    public RainbowCraftingScreenHandler(int syncId, Inventory playerInventory) {
        this(ModScreenHandlers.BOX_SCREEN_HANDLER, syncId, playerInventory, new SimpleContainer(3));
    }

    public RainbowCraftingScreenHandler(int syncId, Inventory playerInventory, Container inventory) {
        super(ModScreenHandlers.BOX_SCREEN_HANDLER, syncId);
        this.access = ContainerLevelAccess.create(playerInventory.player.level(), playerInventory.player.blockPosition());

        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 22));
        this.dyeSlot = this.addSlot(new Slot(this.input, 1, 20, 44) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() == ModItems.RAINBOW_DYE;
            }
        });
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                RainbowCraftingScreenHandler.this.inputSlot.remove(1);
                RainbowCraftingScreenHandler.this.dyeSlot.remove(1);
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
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void slotsChanged(Container inventory) {
        ItemStack materialStack = this.inputSlot.getItem();
        ItemStack dyeStack = this.dyeSlot.getItem();

        if (!materialStack.isEmpty() && !dyeStack.isEmpty()) {
            this.availableRecipes = player.level().getRecipeManager()
                    .getRecipesFor(PrideLand.RAINBOW_CUTTING, new net.minecraft.world.item.crafting.SingleRecipeInput(materialStack), player.level())
                    .stream()
                    .map(entry -> (RainbowCuttingRecipe) entry.value())
                    .toList();
            if (!this.availableRecipes.isEmpty()) {
                this.selectedRecipe = 0;
                populateResult();
            }
        } else {
            this.availableRecipes = java.util.Collections.emptyList();
            this.selectedRecipe = -1;
            this.outputSlot.set(ItemStack.EMPTY);
        }
    }

    private void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.selectedRecipe >= 0 && this.selectedRecipe < this.availableRecipes.size()) {
            RainbowCuttingRecipe recipe = this.availableRecipes.get(this.selectedRecipe);
            this.outputSlot.set(recipe.getResult().copy());
        } else {
            this.outputSlot.set(ItemStack.EMPTY);
        }
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id >= 0 && id < this.availableRecipes.size()) {
            this.selectedRecipe = id;
            this.populateResult();
            return true;
        }
        return false;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasItem()) {
            ItemStack itemStack2 = slot2.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();

            if (slot == 2) { // output
                if (!this.moveItemStackTo(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot2.onQuickChange(itemStack2, itemStack);
            } else if (slot == 0 || slot == 1) { // input or dye
                if (!this.moveItemStackTo(itemStack2, 3, 39, false)) {
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
            } else if (slot >= 30 && slot < 39) {
                if (!this.moveItemStackTo(itemStack2, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemStack2.isEmpty()) {
                slot2.setByPlayer(ItemStack.EMPTY);
            }
            slot2.setChanged();
        }
        return itemStack;
    }

    public int getSelectedRecipe() {
        return selectedRecipe;
    }

    public List<RainbowCuttingRecipe> getAvailableRecipes() {
        return availableRecipes;
    }

    public Slot getDyeSlot() {
        return dyeSlot;
    }

    public boolean canCraft() {
        return this.inputSlot.hasItem() && !this.availableRecipes.isEmpty();
    }
}
