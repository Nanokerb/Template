package Nanokerb.temporial.datagen;

import Nanokerb.temporial.Temporial;
import Nanokerb.temporial.block.ModBlocks;
import Nanokerb.temporial.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> TUNGSTEN_SMELTABLES = List.of(ModItems.RAW_TUNGSTEN.get(),
            ModBlocks.RAW_TUNGSTEN_BLOCK.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN.get(),1, 500,"tungsten");
        oreSmelting(pWriter, TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN.get(),1, 750,"tungsten");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TUNGSTEN.get())
                .unlockedBy(getHasName(ModItems.TUNGSTEN.get()), has(ModItems.TUNGSTEN.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, Temporial.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
