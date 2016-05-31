package mimer29or40.etherealstorage.common.fluid;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.util.Log;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Locale;

public class ModFluids
{
    public static BlockFluidMetal[] blockFluidMetals = new BlockFluidMetal[]{};

    public static void registerFluids()
    { // TODO dynamicly create metals
//        for (MaterialMetal metal : MaterialMetal.values())
//        {
//            if (metal.isTypeSet(MaterialMetal.Type.FLUID))
//            {
//                blockFluidMetals[metal.getMeta()] = registerFluid(BlockFluidMetal.class, FluidBase.class);
//            }
//        }
    }

    private static <BlockFluid extends BlockFluidBase> BlockFluid registerFluid(Class<BlockFluid> blockFluidClass, Class<? extends Fluid> fluidClass)
    {
        BlockFluid blockFluid = null;
        try
        {
            Fluid fluid = fluidClass.getConstructor().newInstance();

            String internalName = fluid.getName();

            fluid.setUnlocalizedName(internalName);

            FluidRegistry.registerFluid(fluid);
            FluidRegistry.addBucketForFluid(fluid);

            blockFluid = blockFluidClass.getConstructor(Fluid.class).newInstance(fluid);

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
            { throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName)); }

            if (internalName.isEmpty())
            { throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", fluid.getClass().getCanonicalName())); }

//            fluid.setRegistryName(ModInfo.MOD_ID, internalName);
            blockFluid.setUnlocalizedName(fluid.getUnlocalizedName());
            blockFluid.setRegistryName(ModInfo.MOD_ID, fluid.getUnlocalizedName());

            GameRegistry.register(blockFluid);

//            if (Platform.isClient())
//            {
//                fluid.registerItemModel();
//            }

            Log.info(String.format("Registered fluid block with fluid (%s)", fluid.getClass().getCanonicalName()));
        }
        catch (Exception e)
        {
            Log.fatal(String.format("Fatal Error while registering fluid block (%s)", blockFluidClass.getCanonicalName()));
            e.printStackTrace();
        }

        return blockFluid;
    }
//    FLUID_METAL(BlockFluidMetal.class, "metal", 0, 1000, 1500, 300, false),
//    ;
//
//    private final Class<? extends BlockFluidBase> blockFluidClass;
//    private BlockFluidBase                        fluidBlock;
//    private Fluid                                 fluid;
//
//    ModFluids(Class<? extends BlockFluidBase> blockFluidClass, String fluidName, int lum, int den, int vis, int temp, boolean isGas)
//    {
//        this.blockFluidClass = blockFluidClass;
//
//        ResourceLocation still = new ResourceLocation(ModInfo.MOD_ID, "blocks/fluid/" + fluidName + "-still");
//        ResourceLocation flowing = new ResourceLocation(ModInfo.MOD_ID, "blocks/fluid/" + fluidName + "-flowing");
//
//        this.fluid = new Fluid(fluidName, still, flowing)
//                .setLuminosity(lum)
//                .setDensity(den)
//                .setViscosity(vis)
//                .setTemperature(temp)
//                .setGaseous(isGas);
//    }
//
//    public static void registerFluids()
//    {
//        for (ModFluids fluid : values())
//        {
//            fluid.registerFluid();
//        }
//    }
//
//    public FluidStack getStack()
//    {
//        return new FluidStack(fluid, 1);
//    }
//
//    public FluidStack getStack(int size)
//    {
//        return new FluidStack(fluid, size);
//    }
//
////    public FluidStack getStack(int size, int meta)
////    {
////        return new FluidStack(fluid, size, nbt);
////    }
//
//    public Fluid getFluid()
//    {
//        return this.fluid;
//    }
//
//    private void registerFluid()
//    {
//        try
//        {
//            String internalName = fluid.getName();
//
//            fluid.setUnlocalizedName(internalName);
//
//            FluidRegistry.registerFluid(fluid);
//            FluidRegistry.addBucketForFluid(fluid);
//
//            fluidBlock = blockFluidClass.getConstructor(Fluid.class).newInstance(fluid);
//
//            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
//                throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName));
//
//            if (internalName.isEmpty())
//                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", fluid.getClass().getCanonicalName
// ()));
//
////            fluid.setRegistryName(ModInfo.MOD_ID, internalName);
//            fluidBlock.setUnlocalizedName(fluid.getUnlocalizedName());
//            fluidBlock.setRegistryName(ModInfo.MOD_ID, fluid.getUnlocalizedName());
//
//            GameRegistry.register(fluidBlock);
//
////            if (Platform.isClient())
////            {
////                fluid.registerItemModel();
////            }
//
//            Log.info(String.format("Registered fluid block with fluid (%s)", fluid.getClass().getCanonicalName()));
//        }
//        catch (Exception e)
//        {
//            Log.fatal(String.format("Fatal Error while registering fluid block (%s)", blockFluidClass.getCanonicalName()));
//            e.printStackTrace();
//        }
//    }
}
