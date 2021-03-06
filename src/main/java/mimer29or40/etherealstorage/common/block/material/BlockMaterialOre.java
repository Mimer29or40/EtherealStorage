package mimer29or40.etherealstorage.common.block.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.common.block.BlockBase;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockMaterialOre extends BlockBase
{
    public static PropertyEnum METAL = PropertyEnum.create("metal", MaterialMetal.class);

    public BlockMaterialOre()
    {
        super(Material.IRON, "material/ore");

        this.internalName = "ore";

        setDefaultState(blockState.getBaseState().withProperty(METAL, MaterialMetal.COPPER));
        setSoundType(SoundType.METAL);
        setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(METAL, MaterialMetal.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        MaterialMetal material = (MaterialMetal) state.getValue(METAL);
        return (material.getMeta());
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, METAL);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.ORE))
            {
                list.add(new ItemStack(itemIn, 1, metal.getMeta()));
            }
        }
    }
}
