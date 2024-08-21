package Nanokerb.temporial.datagen;

import Nanokerb.temporial.Temporial;
import Nanokerb.temporial.block.ModBlocks;
import Nanokerb.temporial.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Temporial.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CINNABAR_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_CINNABAR_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_CINNABAR_BLOCK.get(),
                        ModBlocks.CINNABAR_BLOCK.get(),
                        ModBlocks.RAW_TUNGSTEN_BLOCK.get(),
                        ModBlocks.RAW_CINNABAR_BLOCK.get(),
                        ModBlocks.TUNGSTEN_BLOCK.get()

                        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TUNGSTEN_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK.get());



        }


    }