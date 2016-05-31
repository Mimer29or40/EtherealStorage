package mimer29or40.etherealstorage.proxy;

import mimer29or40.etherealstorage.common.block.ESBlocks;
import mimer29or40.etherealstorage.common.item.ESItems;
import mimer29or40.etherealstorage.common.material.MaterialGear;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import mimer29or40.etherealstorage.common.registry.IRegisterRecipe;
import net.minecraftforge.oredict.OreDictionary;

import java.io.File;

public class CommonProxy implements IProxy
{
    @Override
    public void registerBlocks()
    {
        ESBlocks.registerBlocks();
    }

    @Override
    public void registerItems()
    {
        ESItems.registerItems();
    }

    @Override
    public void registerFluids()
    {

    }

    @Override
    public void registerOreDict()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            int meta = metal.getMeta();
            String metalName = metal.getActualName();

            // Register Ore
            if (metal.isTypeSet(MaterialMetal.Type.ORE))
            {
                String oreDictName = "ore" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ESBlocks.BLOCK_MATERIAL_ORE.getStack(1, meta)); }
            }

            // Register Ore Block
            if (metal.isTypeSet(MaterialMetal.Type.BLOCK))
            {
                String oreDictName = "block" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ESBlocks.BLOCK_MATERIAL_BLOCK.getStack(1, meta)); }
            }

            // Register Ingot
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            {
                String oreDictName = "ingot" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ESItems.ITEM_MATERIAL_INGOT.getStack(1, meta)); }
            }

            // Register Dusts
            if (metal.isTypeSet(MaterialMetal.Type.DUST))
            {
                String oreDictName = "dust" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ESItems.ITEM_MATERIAL_DUST.getStack(1, meta)); }
            }

            // Register Nuggets
            if (metal.isTypeSet(MaterialMetal.Type.NUGGET))
            {
                String oreDictName = "nugget" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ESItems.ITEM_MATERIAL_NUGGET.getStack(1, meta)); }
            }
        }

        // Register Gears
        for (MaterialGear gear : MaterialGear.values())
        {
            String oreDictName = "gear" + gear.getActualName();
            if (!OreDictionary.doesOreNameExist(oreDictName))
            { OreDictionary.registerOre(oreDictName, ESItems.ITEM_MATERIAL_GEAR.getStack(1, gear.getMeta())); }
        }
    }

    @Override
    public void registerRecipes()
    {
        for (ESBlocks block : ESBlocks.values())
        {
            if (block.getBlock() instanceof IRegisterRecipe)
            { ((IRegisterRecipe) block.getBlock()).registerRecipes(); }
        }

        for (ESItems item : ESItems.values())
        {
            if (item.getItem() instanceof IRegisterRecipe)
            { ((IRegisterRecipe) item.getItem()).registerRecipes(); }
        }
    }

    @Override
    public void registerFurnaceRecipes()
    {

    }

    @Override
    public void registerCrusherRecipes()
    {

    }

    @Override
    public void registerEvents()
    {

    }

    @Override
    public void registerGUIs()
    {

    }

    @Override
    public void registerRenderers()
    {

    }

    @Override
    public void registerWorldGen()
    {

    }

    @Override
    public void registerConfiguration(File configFile)
    {

    }
}
