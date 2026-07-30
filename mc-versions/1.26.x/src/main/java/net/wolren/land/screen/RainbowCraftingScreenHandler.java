package net.wolren.land.screen;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Rainbow crafting screen handler.
 * Simplified version - full functionality to be restored with 26.X recipe system.
 */
public class RainbowCraftingScreenHandler extends AbstractContainerMenu {
    private final Container input = new SimpleContainer(3);

    // Client constructor
    public RainbowCraftingScreenHandler(int syncId, Inventory inventory) {
        super(null, syncId);
    }

    public RainbowCraftingScreenHandler(int syncId, Inventory inventory, Container inventory2) {
        super(null, syncId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
