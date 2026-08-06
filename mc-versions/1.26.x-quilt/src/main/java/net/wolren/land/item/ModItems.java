package net.wolren.land.item;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;

import java.util.function.Function;

public class ModItems {
    // Dye
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye",
            properties -> new Item(properties));

    // Tools & Weapons (26.2: pickaxe/sword are plain Items with the tool
    // component; axe/shovel/hoe keep their subclasses for stripping/
    // flattening/tilling - matches the NeoForge build exactly)
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",
            properties -> new Item(properties.sword(ToolMaterial.NETHERITE, 3.0F, -2.4F).stacksTo(1).fireResistant()));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",
            properties -> new Item(properties.pickaxe(ToolMaterial.NETHERITE, 1.0F, -2.8F).stacksTo(1).fireResistant()));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",
            properties -> new AxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",
            properties -> new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3.0F, properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",
            properties -> new HoeItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, properties.stacksTo(1).fireResistant()));

    // Armor (26.2: plain Item with the humanoidArmor property - sets the
    // equippable component with the material's equipment asset + attributes)
    public static final Item RAINBOW_HELMET = registerItem("rainbow_helmet",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.HELMET)));
    public static final Item RAINBOW_CHESTPLATE = registerItem("rainbow_chestplate",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.CHESTPLATE)));
    public static final Item RAINBOW_LEGGINGS = registerItem("rainbow_leggings",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.LEGGINGS)));
    public static final Item RAINBOW_BOOTS = registerItem("rainbow_boots",
            properties -> new Item(properties.stacksTo(1).fireResistant()
                    .humanoidArmor(RainbowArmorMaterial.RAINBOW, ArmorType.BOOTS)));

    // Elytras (26.2: Equippable must carry an asset or the armor layer won't render it)
    public static final Item RAINBOW_ELYTRA = registerElytra("rainbow_elytra");
    public static final Item AGENDER_ELYTRA = registerElytra("agender_elytra");
    public static final Item AROMANTIC_ELYTRA = registerElytra("aromantic_elytra");
    public static final Item ASEXUAL_ELYTRA = registerElytra("asexual_elytra");
    public static final Item BISEXUAL_ELYTRA = registerElytra("bisexual_elytra");
    public static final Item DEMIBOY_ELYTRA = registerElytra("demiboy_elytra");
    public static final Item DEMIGIRL_ELYTRA = registerElytra("demigirl_elytra");
    public static final Item DEMISEXUAL_ELYTRA = registerElytra("demisexual_elytra");
    public static final Item GENDERFLUID_ELYTRA = registerElytra("genderfluid_elytra");
    public static final Item GENDERQUEER_ELYTRA = registerElytra("genderqueer_elytra");
    public static final Item LESBIAN_ELYTRA = registerElytra("lesbian_elytra");
    public static final Item NONBINARY_ELYTRA = registerElytra("nonbinary_elytra");
    public static final Item PANSEXUAL_ELYTRA = registerElytra("pansexual_elytra");
    public static final Item POLYSEXUAL_ELYTRA = registerElytra("polysexual_elytra");
    public static final Item PROGRESS_PRIDE_ELYTRA = registerElytra("progress_pride_elytra");
    public static final Item TRANS_ELYTRA = registerElytra("trans_elytra");

    // Spawn Egg (26.2: bind the entity via the ENTITY_DATA component)
    public static Item RAINBOW_SHEEP_SPAWN_EGG = registerItem("rainbow_sheep_spawn_egg",
            properties -> new RainbowSpawnEggItem(properties.component(DataComponents.ENTITY_DATA,
                    TypedEntityData.of(ModEntities.RAINBOW_SHEEP, new CompoundTag()))));

    // Signs (26.2: SignItem/HangingSignItem pair blocks + wall variants. The
    // item id differs from the standing block id (rainbow_sign vs
    // rainbow_standing_sign), so useBlockDescriptionPrefix would resolve to
    // block.pride_land.rainbow_sign - a key that does not exist. Pin the
    // description to the standing/hanging BLOCK keys (matching 1.20.1
    // BlockItem.getDescriptionId behavior).)
    public static final Item RAINBOW_SIGN = registerItem("rainbow_sign",
            properties -> new SignItem(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN,
                    properties.stacksTo(16).overrideDescription("block.pride_land.rainbow_standing_sign")));
    public static final Item RAINBOW_HANGING_SIGN = registerItem("rainbow_hanging_sign",
            properties -> new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN,
                    properties.stacksTo(16).overrideDescription("block.pride_land.rainbow_hanging_sign")));
    public static Item RAINBOW_BOAT = null;
    public static Item RAINBOW_CHEST_BOAT = null;

    private static Item registerElytra(String name) {
        return registerItem(name, properties -> new CustomElytraItem(properties
                .component(DataComponents.EQUIPPABLE,
                        Equippable.builder(EquipmentSlot.CHEST)
                                .setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA)
                                .setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID,
                                        Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))
                                .setDamageOnHurt(false)
                                .build())));
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PrideLand.LOGGER.info("Registering Items for " + PrideLand.MOD_ID);
    }
}
