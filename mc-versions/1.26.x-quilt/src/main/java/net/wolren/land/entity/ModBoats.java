package net.wolren.land.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.wolren.land.PrideLand;
import net.wolren.land.item.ModItems;

import java.util.function.Supplier;

public class ModBoats {
    // Base id: items are <base>_boat / <base>_chest_boat, model layers boat/<base> / chest_boat/<base>,
    // textures entity/boat/<base>.png / entity/chest_boat/<base>.png
    public static final Identifier RAINBOW_BOAT_ID = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow");

    public static EntityType<Boat> RAINBOW_BOAT_ENTITY;
    public static EntityType<ChestBoat> RAINBOW_CHEST_BOAT_ENTITY;

    public static void registerBoats() {
        PrideLand.LOGGER.info("Registering Boats for " + PrideLand.MOD_ID);

        DelayedItemSupplier boatItem = new DelayedItemSupplier();
        DelayedItemSupplier chestBoatItem = new DelayedItemSupplier();

        RAINBOW_BOAT_ENTITY = registerBoatEntityType("rainbow_boat", boatItem,
                (type, world) -> new Boat(type, world, boatItem));
        RAINBOW_CHEST_BOAT_ENTITY = registerBoatEntityType("rainbow_chest_boat", chestBoatItem,
                (type, world) -> new ChestBoat(type, world, chestBoatItem));

        ModItems.RAINBOW_BOAT = registerBoatItem("rainbow_boat", RAINBOW_BOAT_ENTITY);
        ModItems.RAINBOW_CHEST_BOAT = registerBoatItem("rainbow_chest_boat", RAINBOW_CHEST_BOAT_ENTITY);

        boatItem.set(ModItems.RAINBOW_BOAT);
        chestBoatItem.set(ModItems.RAINBOW_CHEST_BOAT);
    }

    private static <T extends AbstractBoat> EntityType<T> registerBoatEntityType(
            String name, DelayedItemSupplier itemSupplier, EntityType.EntityFactory<T> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id,
                EntityType.Builder.of(factory, MobCategory.MISC)
                        .sized(1.375f, 0.5625f)
                        .eyeHeight(0.5625f)
                        .clientTrackingRange(10)
                        .build(key));
    }

    private static Item registerBoatItem(String name, EntityType<? extends AbstractBoat> entityType) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        return Registry.register(BuiltInRegistries.ITEM, id,
                new BoatItem(entityType, new Item.Properties().stacksTo(1).setId(key)));
    }

    // Boat entities are constructed with a supplier that yields the registered item.
    private static class DelayedItemSupplier implements Supplier<Item> {
        private Item value = Items.AIR;

        void set(Item value) {
            this.value = value;
        }

        @Override
        public Item get() {
            return this.value;
        }
    }
}
