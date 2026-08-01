package net.wolren.land.item;

import net.wolren.land.PrideLand;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * PrideLand item registration using NeoForge's DeferredRegister.
 * Full PrideLand item set ported from 1.21.11 common module.
 */
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PrideLand.MOD_ID);

    // Dye
    public static final DeferredItem<Item> RAINBOW_DYE = ITEMS.registerSimpleItem("rainbow_dye",
            properties -> properties);

    // Tools & Weapons (vanilla Item as placeholders)
    public static final DeferredItem<Item> RAINBOW_SWORD = ITEMS.registerItem("rainbow_sword",
            properties -> new Item(properties.sword(ToolMaterial.NETHERITE, 3.0F, -2.4F).stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_PICKAXE = ITEMS.registerItem("rainbow_pickaxe",
            properties -> new Item(properties.pickaxe(ToolMaterial.NETHERITE, 1.0F, -2.8F).stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_AXE = ITEMS.registerItem("rainbow_axe",
            properties -> new AxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_SHOVEL = ITEMS.registerItem("rainbow_shovel",
            properties -> new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3.0F, properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_HOE = ITEMS.registerItem("rainbow_hoe",
            properties -> new HoeItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, properties.stacksTo(1).fireResistant()));

    // Armor (vanilla Item as placeholders — real armor needs ArmorMaterial)
    public static final DeferredItem<Item> RAINBOW_HELMET = ITEMS.registerItem("rainbow_helmet",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_CHESTPLATE = ITEMS.registerItem("rainbow_chestplate",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_LEGGINGS = ITEMS.registerItem("rainbow_leggings",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> RAINBOW_BOOTS = ITEMS.registerItem("rainbow_boots",
            properties -> new Item(properties.stacksTo(1).fireResistant()));

    // Elytras (16 pride flag elytras)
    public static final DeferredItem<Item> RAINBOW_ELYTRA = ITEMS.registerItem("rainbow_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> TRANS_ELYTRA = ITEMS.registerItem("trans_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> NONBINARY_ELYTRA = ITEMS.registerItem("nonbinary_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> BISEXUAL_ELYTRA = ITEMS.registerItem("bisexual_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> PANSEXUAL_ELYTRA = ITEMS.registerItem("pansexual_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> AROMANTIC_ELYTRA = ITEMS.registerItem("aromantic_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> DEMISEXUAL_ELYTRA = ITEMS.registerItem("demisexual_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> AGENDER_ELYTRA = ITEMS.registerItem("agender_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> PROGRESS_PRIDE_ELYTRA = ITEMS.registerItem("progress_pride_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> ASEXUAL_ELYTRA = ITEMS.registerItem("asexual_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> GENDERFLUID_ELYTRA = ITEMS.registerItem("genderfluid_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> LESBIAN_ELYTRA = ITEMS.registerItem("lesbian_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> DEMIBOY_ELYTRA = ITEMS.registerItem("demiboy_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> DEMIGIRL_ELYTRA = ITEMS.registerItem("demigirl_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> GENDERQUEER_ELYTRA = ITEMS.registerItem("genderqueer_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));
    public static final DeferredItem<Item> POLYSEXUAL_ELYTRA = ITEMS.registerItem("polysexual_elytra",
            properties -> new CustomElytraItem(properties.stacksTo(1).fireResistant()));

    // Spawn egg
    public static final DeferredItem<SpawnEggItem> RAINBOW_SHEEP_SPAWN_EGG = ITEMS.registerItem("rainbow_sheep_spawn_egg",
            properties -> new RainbowSpawnEggItem(properties.component(DataComponents.ENTITY_DATA, TypedEntityData.of(ModEntities.RAINBOW_SHEEP.get(), new CompoundTag()))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
