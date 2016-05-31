package mimer29or40.etherealstorage.proxy;

import mimer29or40.etherealstorage.EtherealStorage;
import mimer29or40.etherealstorage.common.block.BlockBase;
import mimer29or40.etherealstorage.common.block.ModBlocks;
import mimer29or40.etherealstorage.common.config.Config;
import mimer29or40.etherealstorage.common.fluid.ModFluids;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.item.ModItems;
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
        ModBlocks.registerBlocks();
    }

    @Override
    public void registerItems()
    {
        ModItems.registerItems();
    }

    @Override
    public void registerFluids()
    {
        ModFluids.registerFluids();
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
                { OreDictionary.registerOre(oreDictName, ModBlocks.blockMaterialOre.getStack(1, meta)); }
            }

            // Register Ore Block
            if (metal.isTypeSet(MaterialMetal.Type.BLOCK))
            {
                String oreDictName = "block" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ModBlocks.blockMaterialBlock.getStack(1, meta)); }
            }

            // Register Ingot
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            {
                String oreDictName = "ingot" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ModItems.itemMaterialIngot.getStack(1, meta)); }
            }

            // Register Dusts
            if (metal.isTypeSet(MaterialMetal.Type.DUST))
            {
                String oreDictName = "dust" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ModItems.itemMaterialDust.getStack(1, meta)); }
            }

            // Register Nuggets
            if (metal.isTypeSet(MaterialMetal.Type.NUGGET))
            {
                String oreDictName = "nugget" + metalName;
                if (!OreDictionary.doesOreNameExist(oreDictName))
                { OreDictionary.registerOre(oreDictName, ModItems.itemMaterialNugget.getStack(1, meta)); }
            }
        }

        // Register Gears
        for (MaterialGear gear : MaterialGear.values())
        {
            String oreDictName = "gear" + gear.getActualName();
            if (!OreDictionary.doesOreNameExist(oreDictName))
            { OreDictionary.registerOre(oreDictName, ModItems.itemMaterialGear.getStack(1, gear.getMeta())); }
        }
    }

    @Override
    public void registerRecipes()
    {
        for (BlockBase block : ModBlocks.getBlocks())
        {
            if (block instanceof IRegisterRecipe)
            { ((IRegisterRecipe) block).registerRecipes(); }
        }

        for (ItemBase item : ModItems.getItems())
        {
            if (item instanceof IRegisterRecipe)
            { ((IRegisterRecipe) item).registerRecipes(); }
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
        EtherealStorage.configuration = Config.initConfig(configFile);
    }
}
