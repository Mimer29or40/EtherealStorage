package mimer29or40.etherealstorage.proxy;

import mimer29or40.etherealstorage.common.block.ESBlocks;
import mimer29or40.etherealstorage.common.item.ESItems;
import mimer29or40.etherealstorage.common.material.MaterialGear;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
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
    public void registerOreDict()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            int meta = metal.getMeta();
            String metalName = metal.getMetalName();

            // Register Ore
//            if (metal.isTypeSet(MaterialMetal.Type.ORE))
//                OreDictionary.registerOre("ore" + metalName, Blocks.BLOCK_ORE.getStack(1, meta));

            // Register Ore Block
//            if (metal.isTypeSet(MaterialMetal.Type.BLOCK))
//                OreDictionary.registerOre("block" + metalName, Blocks.BLOCK_ORE_BLOCK.getStack(1, meta));

            // Register Ingot
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            { OreDictionary.registerOre("ingot" + metalName, ESItems.ITEM_MATERIAL_INGOT.getStack(1, meta)); }

            // Register Dusts
            if (metal.isTypeSet(MaterialMetal.Type.DUST))
            { OreDictionary.registerOre("dust" + metalName, ESItems.ITEM_MATERIAL_DUST.getStack(1, meta)); }

            // Register Nuggets
            if (metal.isTypeSet(MaterialMetal.Type.NUGGET))
            { OreDictionary.registerOre("nugget" + metalName, ESItems.ITEM_MATERIAL_NUGGET.getStack(1, meta)); }
        }

        // Register Gears
        for (MaterialGear gear : MaterialGear.values())
        {
            OreDictionary.registerOre("gear" + gear.getGearName(), ESItems.ITEM_MATERIAL_GEAR.getStack(1, gear.getMeta()));
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
    public void registerRecipes()
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

    @Override
    public void registerFluids()
    {

    }
}
