package Nanokerb.temporial.block;

import Nanokerb.temporial.Temporial;
import Nanokerb.temporial.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Temporial.MOD_ID);

    public static final RegistryObject<Block> RAW_CINNABAR_BLOCK = registerBlock("raw_cinnabar_block",
          () ->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                  .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = registerBlock("raw_tungsten_block",
            () ->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                    .strength(15f).requiresCorrectToolForDrops(), UniformInt.of(5, 9)));

    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));





    public static final RegistryObject<Block> CINNABAR_BLOCK = registerBlock("cinnabar_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void block_register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}