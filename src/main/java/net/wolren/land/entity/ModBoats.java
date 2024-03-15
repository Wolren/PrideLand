package net.wolren.land.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;

public class ModBoats {
    public static final Identifier RAINBOW_BOAT_ID = new Identifier(Land.MOD_ID, "rainbow_boat");
    public static final Identifier RAINBOW_CHEST_BOAT_ID = new Identifier(Land.MOD_ID, "rainbow_chest_boat");

    public static final RegistryKey<TerraformBoatType> RAINBOW_BOAT_KEY = TerraformBoatTypeRegistry.createKey(RAINBOW_BOAT_ID);

    public static void registerBoats() {
        Land.LOGGER.info("Registering Boats for " + Land.MOD_ID);
        TerraformBoatType rainbowBoat = new TerraformBoatType.Builder()
                .item(ModItems.RAINBOW_BOAT)
                .chestItem(ModItems.RAINBOW_CHEST_BOAT)
                .planks(ModBlocks.RAINBOW_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, RAINBOW_BOAT_KEY, rainbowBoat);
    }
}
