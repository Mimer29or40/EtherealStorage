package mimer29or40.etherealstorage.common.item.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

import java.util.List;

public class ItemMaterialIngot extends ItemBase
{
    public ItemMaterialIngot()
    {
        super("material/ingot");

        this.internalName = "ingot";

        setHasSubtypes(true);
        setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            {
                subItems.add(new ItemStack(this, 1, metal.getMeta()));
            }
        }
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

    @Override
    public void registerItemRenderer()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            {
                ModelLoader.setCustomModelResourceLocation(this, metal.getMeta(), new ModelResourceLocation(
                        ModInfo.MOD_ID + ":material/ingot/ingot_" + metal.getUnlocalizedName(), "inventory"));
            }
        }
    }
}
