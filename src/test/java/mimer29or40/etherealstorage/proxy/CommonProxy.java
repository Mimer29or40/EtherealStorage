package mimer29or40.etherealstorage.proxy;

import mimer29or40.etherealstorage.EtherealStorage;
import mimer29or40.etherealstorage.common.block.ESBlocks;
import mimer29or40.etherealstorage.common.config.Config;
import mimer29or40.etherealstorage.common.item.ESItems;

import java.io.File;

public abstract class CommonProxy implements IProxy
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
//        for (EnumOres ores : EnumOres.values())
//        {
//            int meta = ores.getMeta();
//            String oreName = ores.getMetalName();
//
//            // Register Ore
//            if (ores.isTypeSet(EnumOreType.ORE))
//                OreDictionary.registerOre("ore" + oreName, Blocks.BLOCK_ORE.getStack(1, meta));
//
//            // Register Ore Block
//            if (ores.isTypeSet(EnumOreType.BLOCK))
//                OreDictionary.registerOre("block" + oreName, Blocks.BLOCK_ORE_BLOCK.getStack(1, meta));
//
//            // Register Ingot
//            if (ores.isTypeSet(EnumOreType.INGOT))
//                OreDictionary.registerOre("ingot" + oreName, Items.ITEM_ORE_INGOT.getStack(1, meta));
//
//            // Register Dusts
//            if (ores.isTypeSet(EnumOreType.DUST))
//                OreDictionary.registerOre("dust" + oreName, Items.ITEM_ORE_DUST.getStack(1, meta));
//
//            // Register Nuggets
//            if (ores.isTypeSet(EnumOreType.NUGGET))
//                OreDictionary.registerOre("nugget" + oreName, Items.ITEM_ORE_NUGGET.getStack(1, meta));
//
//            // Register Gears
//            if (ores.isTypeSet(EnumOreType.GEAR))
//                OreDictionary.registerOre("gear" + oreName, Items.ITEM_MATERIAL_GEAR.getStack(1, meta));
//        }
    }

    @Override
    public void registerFluids()
    {
//        for (EnumOres ores : EnumOres.values())
//        {
//            int meta = ores.getMeta();
//            String oreName = ores.getName();
//
//            if (ores.isTypeSet(EnumOreType.FLUID))
//            {
//                Fluid fluid = FluidHelper.createFluid(oreName, "appliedlogistics:fluids." + oreName, false);
//                FluidRegistry.addBucketForFluid(fluid);
//
//                FluidHelper.registerFluidBlock(new BlockFluidBlock(fluid));
//            }
//        }
    }

    @Override
    public void registerCrusherRecipes()
    {
//        // Ores -> Dust
//        for (EnumOres ores : EnumOres.values())
//        {
//            String oreName = ores.getMetalName();
//
//            if (ores.isTypeSet(EnumOreType.DUST) && (ores.isTypeSet(EnumOreType.ORE) || ores.isTypeSet(EnumOreType.VANILLA)))
//            {
//                HammerRegistry.registerOreDictOre(oreName);
//                PulverizerRegistry.registerOreDictOre(oreName);
//            }
//
//            if (ores.isTypeSet(EnumOreType.INGOT) && (ores.isTypeSet(EnumOreType.ORE) || ores.isTypeSet(EnumOreType.VANILLA)))
//            {
//                PulverizerRegistry.registerOreDictIngot(oreName);
//            }
//        }
//
//        // Add other misc vanilla things
//
//        // Coal
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), Items.ITEM_ORE_NUGGET.getStack(1, EnumOres.DIAMOND.getMeta()),
//                                0.005f, 0.01f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), new ItemStack(net.minecraft.init.Items.coal, 2), 1.0f, 0.5f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), new ItemStack(net.minecraft.init.Items.coal, 1), 0.5f, 0.5f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), new ItemStack(net.minecraft.init.Items.coal, 1), 0.5f, 0.5f);
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), Items.ITEM_ORE_NUGGET.getStack(1, EnumOres.DIAMOND.getMeta
// ()),
//                                    0.05f, true);
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.coal_ore), new ItemStack(net.minecraft.init.Items.coal, 2), 1.5f, true);
//
//        // Redstone
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 6), 1.0f,
//                                0.5f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 4), 0.1f,
//                                0.1f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 2), 0.0f,
//                                0.5f);
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 4), 4
// .0f,
//                                    true);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.lit_redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 6), 1
// .0f,
//                                0.5f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.lit_redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 4), 0
// .1f,
//                                0.1f);
//        HammerRegistry.register(new ItemStack(net.minecraft.init.Blocks.lit_redstone_ore), new ItemStack(net.minecraft.init.Items.redstone, 2), 0
// .0f,
//                                0.5f);
//
//        // Stone
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.stone), new ItemStack(net.minecraft.init.Blocks.cobblestone), 1.0f,
//                                    false);
//
//        // Cobblestone
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.cobblestone), new ItemStack(net.minecraft.init.Blocks.gravel), 1.0f,
//                                    false);
//
//        // Gravel
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.gravel), new ItemStack(net.minecraft.init.Blocks.sand), 1.0f, false);
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.gravel), new ItemStack(net.minecraft.init.Items.flint), 0.1f, true);
//
//        // Sand
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.sand), new ItemStack(net.minecraft.init.Blocks.clay), 1.0f, false);
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.sandstone), new ItemStack(net.minecraft.init.Blocks.sand), 4.0f, false);
//
//        // Clay
//        PulverizerRegistry.register(new ItemStack(net.minecraft.init.Blocks.clay), new ItemStack(net.minecraft.init.Items.clay_ball), 4.0f, true);
    }

    @Override
    public void registerFurnaceRecipes()
    {
//        for (Items item : Items.values())
//        {
//            if (item.getItem() instanceof IProvideSmelting)
//                ((IProvideSmelting) item.getItem()).RegisterSmelting();
//        }
//
//        for (Blocks block : Blocks.values())
//        {
//            if (block.getBlock() instanceof IProvideSmelting)
//                ((IProvideSmelting) block.getBlock()).RegisterSmelting();
//        }
    }

    @Override
    public void registerEvents()
    {
//        for (Items item : Items.values())
//        {
//            if (item.getItem() instanceof IProvideEvent)
//                MinecraftForge.EVENT_BUS.register(item.getItem());
//        }
//
//        for (Blocks block : Blocks.values())
//        {
//            if (block.getBlock() instanceof IProvideEvent)
//                MinecraftForge.EVENT_BUS.register(block.getBlock());
//        }
    }

    @Override
    public void registerRecipes()
    {
//        for (Items item : Items.values())
//        {
//            if (item.getItem() instanceof IProvideRecipe)
//                ((IProvideRecipe) item.getItem()).RegisterRecipes();
//        }
//
//        for (Blocks block : Blocks.values())
//        {
//            if (block.getBlock() instanceof IProvideRecipe)
//                ((IProvideRecipe) block.getBlock()).RegisterRecipes();
//        }
    }

    @Override
    public void registerGUIs()
    {
//        NetworkRegistry.INSTANCE.registerGuiHandler(AppliedLogistics.instance, new GuiHandler());
    }

    @Override
    public void registerRenderers()
    {

    }

    @Override
    public void registerWorldGen()
    {
//        WorldGenInit.init();
    }

    @Override
    public void registerConfiguration(File configFile)
    {
        EtherealStorage.configuration = Config.initConfig(configFile);
    }
}
