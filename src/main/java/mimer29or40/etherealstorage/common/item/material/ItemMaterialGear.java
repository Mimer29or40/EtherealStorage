package mimer29or40.etherealstorage.common.item.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.material.MaterialGear;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

import java.util.List;

public class ItemMaterialGear extends ItemBase
{
    public ItemMaterialGear()
    {
        super("material/gear");

        this.internalName = "gear";

        setHasSubtypes(true);
        setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (MaterialGear gear : MaterialGear.values())
        {
            subItems.add(new ItemStack(itemIn, 1, gear.getMeta()));
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
        String gearName = MaterialGear.values()[stack.getItemDamage()].getUnlocalizedName();
        return name + "." + gearName;
    }

    @Override
    public void registerItemRenderer()
    {
        for (MaterialGear gear : MaterialGear.values())
        {
            ModelLoader.setCustomModelResourceLocation(this, gear.getMeta(), new ModelResourceLocation(
                    ModInfo.MOD_ID + ":material/gear/gear_" + gear.getUnlocalizedName(), "inventory"));
        }
    }
}
