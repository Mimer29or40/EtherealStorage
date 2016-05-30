package mimer29or40.etherealstorage.common.block.blockmaterial;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.common.block.BlockBase;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import mimer29or40.etherealstorage.common.material.MaterialMetalType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockMetalBlock extends BlockBase
{
    public static final PropertyEnum METALS = PropertyEnum.create("metal", MaterialMetal.class);

    public BlockMetalBlock()
    {
        super(Material.IRON, "material/metal/metal_block");

        this.internalName = "metal_block";

        this.setDefaultState(this.blockState.getBaseState().withProperty(METALS, MaterialMetal.COPPER));
        this.setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(METALS, MaterialMetal.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        MaterialMetal ores = (MaterialMetal) state.getValue(METALS);
        return (ores.getMeta());
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, METALS);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (int i = 0; i < MaterialMetal.values().length; i++)
        {
            if (MaterialMetal.byMeta(i).isTypeSet(MaterialMetalType.ORE))
            {
                list.add(new ItemStack(itemIn, 1, i));
            }
        }
    }
}
