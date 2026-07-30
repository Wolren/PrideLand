package net.wolren.land.item.material;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;

import java.util.EnumMap;
import java.util.List;

public class RainbowArmorMaterial {
    public static final Holder<ArmorMaterial> RAINBOW =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, PrideLand.MOD_ID)
                    .register("rainbow", () -> new ArmorMaterial(
                            new EnumMap<>(ArmorItem.Type.class) {{
                                put(ArmorItem.Type.HELMET, 3);
                                put(ArmorItem.Type.CHESTPLATE, 8);
                                put(ArmorItem.Type.LEGGINGS, 6);
                                put(ArmorItem.Type.BOOTS, 3);
                            }},
                            19,
                            SoundEvents.ARMOR_EQUIP_NETHERITE,
                            3.0F,
                            0.1F,
                            Ingredient.of(Items.NETHERITE_INGOT),
                            List.of(new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow")))
                    )).getHolder();
}
