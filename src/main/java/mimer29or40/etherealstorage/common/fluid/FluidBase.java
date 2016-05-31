package mimer29or40.etherealstorage.common.fluid;

import mimer29or40.etherealstorage.ModInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public abstract class FluidBase extends Fluid
{
    protected String resourcePath = "";
    protected String internalName = "";

    public FluidBase(String fluidName, String resourcePath)
    {
        super(fluidName,
              new ResourceLocation(ModInfo.MOD_ID, resourcePath + "-still"),
              new ResourceLocation(ModInfo.MOD_ID, resourcePath + "-flow"));

        this.resourcePath = resourcePath;
    }

    public String getInternalName()
    {
        return internalName;
    }

    @Override
    public String getUnlocalizedName()
    {
        String fluidName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

        return String.format("fluid.%s.%s", ModInfo.MOD_ID, fluidName);
    }

    private String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
