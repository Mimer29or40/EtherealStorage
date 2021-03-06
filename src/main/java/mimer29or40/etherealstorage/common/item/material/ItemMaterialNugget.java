package mimer29or40.etherealstorage.common.item.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.item.ModItems;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import mimer29or40.etherealstorage.common.registry.IRegisterRecipe;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.List;

public class ItemMaterialNugget extends ItemBase implements IRegisterRecipe
{
    public ItemMaterialNugget()
    {
        super("material/nugget");

        this.internalName = "nugget";

        setHasSubtypes(true);
        setCreativeTab(EtherealStorageCreativeTabs.tabGeneral);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.NUGGET))
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
        String metalName = MaterialMetal.byMeta(stack.getItemDamage()).getName();
        return name + "." + metalName;
    }

    @Override
    public void registerItemModel()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.NUGGET))
            {
                ModelLoader.setCustomModelResourceLocation(this, metal.getMeta(), new ModelResourceLocation(
                        ModInfo.MOD_ID + ":material/nugget/nugget_" + metal.getName(), "inventory"));
            }
        }
    }

    @Override
    public void registerRecipes()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            String metalName = metal.getActualName();

            if (metal.isTypeSet(MaterialMetal.Type.NUGGET, MaterialMetal.Type.INGOT))
            { GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemMaterialNugget.getStack(9, metal.getMeta()), "ingot" + metalName)); }
        }
    }
}
