package mimer29or40.etherealstorage.common.fluid;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public abstract class BlockFluidBase extends BlockFluidClassic
{
    protected String resourcePath = "";
    protected String internalName = "";

    public BlockFluidBase(Fluid fluid, String resourcePath)
    {
        super(fluid, Material.WATER);

        this.resourcePath = resourcePath;
    }

    public String getInternalName()
    {
        return this.internalName;
    }

    @Override
    public String getUnlocalizedName()
    {
        Fluid fluid = FluidRegistry.getFluid(fluidName);
        if (fluid != null) return fluid.getUnlocalizedName();
        return super.getUnlocalizedName();
    }

    public FluidStack getStack()
    {
        return new FluidStack(getFluid(), 1);
    }

    public FluidStack getStack(int size)
    {
        return new FluidStack(getFluid(), size);
    }
}
