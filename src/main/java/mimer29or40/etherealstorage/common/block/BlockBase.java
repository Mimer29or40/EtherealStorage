package mimer29or40.etherealstorage.common.block;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.registry.IRegisterBlockRenderer;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockBase extends Block implements IRegisterBlockRenderer
{
    protected String resourcePath = "";
    protected String internalName = "";

    public BlockBase(Material material, String resourcePath)
    {
        super(material);

        this.resourcePath = resourcePath;

        setSoundType(SoundType.STONE);
        setHardness(2.2F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 0);
    }

    public String getInternalName()
    {
        return internalName;
    }

    @Override
    public String getUnlocalizedName()
    {
        String blockName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

        return String.format("tile.%s.%s", ModInfo.MOD_ID, blockName);
    }

    private String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockRenderer()
    {
        final String resourcePath = String.format("%s:%s", ModInfo.MOD_ID, this.resourcePath);
        Log.info(resourcePath);

        ModelLoader.setCustomStateMapper(this, new DefaultStateMapper()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(resourcePath, getPropertyString(state.getProperties()));
            }
        });
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockItemRenderer()
    {
        final String resourcePath = String.format("%s:%s", ModInfo.MOD_ID, this.resourcePath);
        Log.info(resourcePath);

        List<ItemStack> subBlocks = new ArrayList<>();
        getSubBlocks(Item.getItemFromBlock(this), null, subBlocks);

        for (ItemStack itemStack : subBlocks)
        {
            IBlockState blockState = this.getStateFromMeta(itemStack.getItemDamage());
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), itemStack.getItemDamage(),
                                                       new ModelResourceLocation(resourcePath, Platform.getPropertyString(blockState.getProperties()))
                                                      );

        }
    }
}
