package Nanokerb.temporial.datagen;

import Nanokerb.temporial.Temporial;
import Nanokerb.temporial.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Temporial.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CINNABAR_BLOCK);
        blockWithItem(ModBlocks.TUNGSTEN_BLOCK);
        blockWithItem(ModBlocks.RAW_CINNABAR_BLOCK);
        blockWithItem(ModBlocks.RAW_TUNGSTEN_BLOCK);



    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
