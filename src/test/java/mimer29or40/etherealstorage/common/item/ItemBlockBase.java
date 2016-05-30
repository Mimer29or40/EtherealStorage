package mimer29or40.etherealstorage.common.item;

import mimer29or40.etherealstorage.common.material.MaterialMetal;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock
{
    protected String internalName = "";

    public ItemBlockBase(Block block)
    {
        super(block);

        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        String name = super.getUnlocalizedName();
        String metalName = MaterialMetal.byMeta(stack.getItemDamage()).getUnlocalizedName();
        return name + "." + metalName;
    }
}
