package Nanokerb.temporial.item;


import Nanokerb.temporial.Temporial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Temporial.MOD_ID);

    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN = ITEMS.register("tungsten", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
