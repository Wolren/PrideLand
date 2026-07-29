package net.wolren.land.screen;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.screen.ingame.LoomScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.wolren.land.Land;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;

import java.util.List;

public class RainbowCraftingScreenHandler extends ScreenHandler {
    final Slot dyeSlot;
    final Slot inputSlot;
    final Slot outputSlot;
    private final Property selectedRecipe = Property.create();
    private final World world;
    private List<RainbowCuttingRecipe> availableRecipes = Lists.newArrayList();
    private ItemStack inputStack = ItemStack.EMPTY;
    private ItemStack dyeStack = ItemStack.EMPTY;

    Runnable contentsChangedListener = () -> {
    };

    public final Inventory input = new SimpleInventory(2) {
        public void markDirty() {
            super.markDirty();
            RainbowCraftingScreenHandler.this.onContentChanged(this);
            RainbowCraftingScreenHandler.this.contentsChangedListener.run();
        }
    };

    final CraftingResultInventory output = new CraftingResultInventory();

    public RainbowCraftingScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, new SimpleInventory(3));
    }

    public RainbowCraftingScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.BOX_SCREEN_HANDLER, syncId);
        this.world = playerInventory.player.getWorld();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 22));

        this.dyeSlot = this.addSlot(new Slot(this.input, 1, 20, 44) {
            public boolean canInsert(ItemStack stack) {
                Item item = stack.getItem();
                return item == ModItems.RAINBOW_DYE;
            }
        });

        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraft(player.getWorld(), player, stack.getCount());
                RainbowCraftingScreenHandler.this.output.unlockLastRecipe(player);
                ItemStack materialStack = RainbowCraftingScreenHandler.this.inputSlot.takeStack(1);
                ItemStack dyeStack = RainbowCraftingScreenHandler.this.dyeSlot.takeStack(1);
                if (!materialStack.isEmpty() && !(dyeStack.getCount() <= 0)) {
                    RainbowCraftingScreenHandler.this.populateResult();
                }

                super.onTakeItem(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(RainbowCraftingScreenHandler.this.inputSlot.getStack());
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

        this.addProperty(this.selectedRecipe);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
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
        return this.inputSlot.hasStack() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
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
    public void onContentChanged(Inventory inventory) {
        ItemStack materialStack = this.inputSlot.getStack();
        ItemStack dyeStack = this.dyeSlot.getStack();


        if (!materialStack.isOf(this.inputStack.getItem())) {
            this.inputStack = materialStack.copy();
            this.updateInput(inventory, materialStack, dyeStack);
        }

        if (!dyeStack.isOf(this.dyeStack.getItem())) {
            this.dyeStack = dyeStack.copy();
            this.updateInput(inventory, materialStack, dyeStack);
        }
    }


    private void updateInput(Inventory input, ItemStack materialStack, ItemStack dyeStack) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
        if (!materialStack.isEmpty() && !dyeStack.isEmpty()) {
            this.availableRecipes = this.world.getRecipeManager().getAllMatches(Land.RAINBOW_CUTTING, input, this.world);
        }
    }

    void populateResult() {
        if (!RainbowCraftingScreenHandler.this.dyeSlot.getStack().isEmpty() && !this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RainbowCuttingRecipe rainbowCuttingRecipe = this.availableRecipes.get(this.selectedRecipe.get());
            ItemStack itemStack = rainbowCuttingRecipe.craft(this.input, this.world.getRegistryManager());
            if (itemStack.isItemEnabled(this.world.getEnabledFeatures())) {
                this.output.setLastRecipe(rainbowCuttingRecipe);
                this.outputSlot.setStackNoCallbacks(itemStack);
            } else {
                this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
        }

        this.sendContentUpdates();
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();

            if (slot == 2) {
                item.onCraft(itemStack2, player.getWorld(), player);
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot == 0 || slot == 1) {
                if (!this.insertItem(itemStack2, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.world
                    .getRecipeManager()
                    .getFirstMatch(Land.RAINBOW_CUTTING, new SimpleInventory(itemStack2), this.world)
                    .isPresent()) {
                if (!this.insertItem(itemStack2, this.inputSlot.id, this.inputSlot.id + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (item == ModItems.RAINBOW_DYE) {
                if (!this.insertItem(itemStack2, this.dyeSlot.id, this.dyeSlot.id + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 3 && slot < 30) {
                if (!this.insertItem(itemStack2, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 30 && slot < 39 && !this.insertItem(itemStack2, 3, 30, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            }

            slot2.markDirty();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
            this.sendContentUpdates();
        }

        return itemStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.output.removeStack(1);
        this.dropInventory(player, this.input);
    }

    public Slot getDyeSlot() {
        return this.dyeSlot;
    }
}




