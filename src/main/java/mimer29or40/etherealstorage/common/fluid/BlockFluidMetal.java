package mimer29or40.etherealstorage.common.fluid;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockFluidMetal extends BlockFluidBase
{

    public BlockFluidMetal(Fluid fluid)
    {
        super(fluid, "fluid/metal");

        this.internalName = "metal";

        setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public String getUnlocalizedName()
    {
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if (fluid != null)
        {
            return fluid.getUnlocalizedName();
        }
        return super.getUnlocalizedName();
    }
}
