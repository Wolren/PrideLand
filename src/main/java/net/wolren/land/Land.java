package net.wolren.land;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.recipe.RecipeType;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItemGroups;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.spawn.SpawnModifier;
import net.wolren.land.util.config.RainbowConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Land implements ModInitializer {
	public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static RecipeType<RainbowCuttingRecipe> RAINBOW_CUTTING;

	@Override
	public void onInitialize() {
		AutoConfig.register(RainbowConfig.class, GsonConfigSerializer::new);
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModSerializers.registerCuttingSerializers();
		ModBoats.registerBoats();
		FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_SHEEP, createSheepAttributes());
		SpawnModifier.modifySpawning();
		RAINBOW_CUTTING = RecipeType.register(MOD_ID + ":" + "rainbow_cutting");
	}

	public static DefaultAttributeContainer.Builder createSheepAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F);
	}
}