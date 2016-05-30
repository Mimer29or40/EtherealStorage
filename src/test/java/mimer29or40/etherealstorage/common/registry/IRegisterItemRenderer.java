package mimer29or40.etherealstorage.common.registry;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IRegisterItemRenderer
{
    @SideOnly(Side.CLIENT)
    void registerItemRenderer();
}
