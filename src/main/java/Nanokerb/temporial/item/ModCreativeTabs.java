package Nanokerb.temporial.item;

import Nanokerb.temporial.Temporial;
import Nanokerb.temporial.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Temporial.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEMPORIAL_TAB = CREATIVE_MOD_TABS.register("temporial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CINNABAR.get()))
                    .title(Component.translatable("creativetab.temporial_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CINNABAR.get());
                        output.accept(ModItems.RAW_TUNGSTEN.get());
                        output.accept(ModItems.TUNGSTEN.get());
                        output.accept(ModBlocks.CINNABAR_BLOCK.get());
                        output.accept(ModBlocks.RAW_CINNABAR_BLOCK.get());
                        output.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                        output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
                    })

                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
