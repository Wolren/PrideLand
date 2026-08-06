package net.wolren.land.item;

import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
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

    // Armor (26.2: plain Item with the humanoidArmor property - sets the
    // equippable component with the material's equipment asset + attributes)
    public static final DeferredItem<Item> RAINBOW_HELMET = ITEMS.registerItem("rainbow_helmet",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.HELMET)));
    public static final DeferredItem<Item> RAINBOW_CHESTPLATE = ITEMS.registerItem("rainbow_chestplate",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> RAINBOW_LEGGINGS = ITEMS.registerItem("rainbow_leggings",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> RAINBOW_BOOTS = ITEMS.registerItem("rainbow_boots",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.BOOTS)));

    // Elytras (16 pride flag elytras; EQUIPPABLE must carry the per-elytra
    // equipment asset or the armor layer won't render them)
    public static final DeferredItem<Item> RAINBOW_ELYTRA = elytra("rainbow_elytra");
    public static final DeferredItem<Item> TRANS_ELYTRA = elytra("trans_elytra");
    public static final DeferredItem<Item> NONBINARY_ELYTRA = elytra("nonbinary_elytra");
    public static final DeferredItem<Item> BISEXUAL_ELYTRA = elytra("bisexual_elytra");
    public static final DeferredItem<Item> PANSEXUAL_ELYTRA = elytra("pansexual_elytra");
    public static final DeferredItem<Item> AROMANTIC_ELYTRA = elytra("aromantic_elytra");
    public static final DeferredItem<Item> DEMISEXUAL_ELYTRA = elytra("demisexual_elytra");
    public static final DeferredItem<Item> AGENDER_ELYTRA = elytra("agender_elytra");
    public static final DeferredItem<Item> PROGRESS_PRIDE_ELYTRA = elytra("progress_pride_elytra");
    public static final DeferredItem<Item> ASEXUAL_ELYTRA = elytra("asexual_elytra");
    public static final DeferredItem<Item> GENDERFLUID_ELYTRA = elytra("genderfluid_elytra");
    public static final DeferredItem<Item> GENDERQUEER_ELYTRA = elytra("genderqueer_elytra");
    public static final DeferredItem<Item> LESBIAN_ELYTRA = elytra("lesbian_elytra");
    public static final DeferredItem<Item> DEMIBOY_ELYTRA = elytra("demiboy_elytra");
    public static final DeferredItem<Item> DEMIGIRL_ELYTRA = elytra("demigirl_elytra");
    public static final DeferredItem<Item> POLYSEXUAL_ELYTRA = elytra("polysexual_elytra");

    // Spawn egg
    public static final DeferredItem<SpawnEggItem> RAINBOW_SHEEP_SPAWN_EGG = ITEMS.registerItem("rainbow_sheep_spawn_egg",
            properties -> new RainbowSpawnEggItem(properties.component(DataComponents.ENTITY_DATA, TypedEntityData.of(ModEntities.RAINBOW_SHEEP.get(), new CompoundTag()))));

    // Signs (26.2: SignItem/HangingSignItem pair the block + wall variants. The
    // item id differs from the standing block id (rainbow_sign vs
    // rainbow_standing_sign), so useBlockDescriptionPrefix would resolve to
    // block.pride_land.rainbow_sign - a key that does not exist. Pin the
    // description to the standing/hanging BLOCK keys (matching 1.20.1
    // BlockItem.getDescriptionId behavior).)
    public static final DeferredItem<SignItem> RAINBOW_SIGN = ITEMS.registerItem("rainbow_sign",
            properties -> new SignItem(ModBlocks.RAINBOW_STANDING_SIGN.get(), ModBlocks.RAINBOW_WALL_SIGN.get(),
                    properties.stacksTo(16).overrideDescription("block.pride_land.rainbow_standing_sign")));
    public static final DeferredItem<HangingSignItem> RAINBOW_HANGING_SIGN = ITEMS.registerItem("rainbow_hanging_sign",
            properties -> new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN.get(), ModBlocks.RAINBOW_WALL_HANGING_SIGN.get(),
                    properties.stacksTo(16).overrideDescription("block.pride_land.rainbow_hanging_sign")));

    // Boats (26.2: BoatItem takes the entity type; the entity is created with
    // the item supplier so dropped boats restore the right item)
    public static final DeferredItem<BoatItem> RAINBOW_BOAT = ITEMS.registerItem("rainbow_boat",
            properties -> new BoatItem(ModEntities.RAINBOW_BOAT.get(), properties.stacksTo(1)));
    public static final DeferredItem<BoatItem> RAINBOW_CHEST_BOAT = ITEMS.registerItem("rainbow_chest_boat",
            properties -> new BoatItem(ModEntities.RAINBOW_CHEST_BOAT.get(), properties.stacksTo(1)));

    private static DeferredItem<Item> elytra(String name) {
        return ITEMS.registerItem(name, properties -> new CustomElytraItem(properties
                .stacksTo(1).fireResistant()
                .component(DataComponents.EQUIPPABLE,
                        Equippable.builder(EquipmentSlot.CHEST)
                                .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                                .setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID,
                                        Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))
                                .setDamageOnHurt(false)
                                .build())));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
