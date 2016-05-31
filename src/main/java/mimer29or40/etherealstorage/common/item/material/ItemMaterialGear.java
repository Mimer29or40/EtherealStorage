package mimer29or40.etherealstorage.common.item.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.ESItems;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.material.MaterialGear;
import mimer29or40.etherealstorage.common.registry.IRegisterRecipe;
import mimer29or40.etherealstorage.common.util.Log;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.List;

public class ItemMaterialGear extends ItemBase implements IRegisterRecipe
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
        String gearName = MaterialGear.values()[stack.getItemDamage()].getName();
        return name + "." + gearName;
    }

    @Override
    public void registerItemModel()
    {
        for (MaterialGear gear : MaterialGear.values())
        {
            ModelLoader.setCustomModelResourceLocation(this, gear.getMeta(), new ModelResourceLocation(
                    ModInfo.MOD_ID + ":material/gear/gear_" + gear.getName(), "inventory"));
        }
    }

    @Override
    public void registerRecipes()
    {
        for (MaterialGear gear : MaterialGear.values())
        {
            String ingotName = "ingot" + gear.getActualName();

            if (!OreDictionary.doesOreNameExist(ingotName)) continue;

            GameRegistry.addRecipe(new ShapedOreRecipe(ESItems.ITEM_MATERIAL_GEAR.getStack(1, gear.getMeta()),
                                                       " x ",
                                                       "xox",
                                                       " x ",
                                                       'x', ingotName,
                                                       'o', "ingotIron"));
            Log.info("Recipe for gear%s created with %s", gear.getActualName(), ingotName);
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(ESItems.ITEM_MATERIAL_GEAR.getStack(1, MaterialGear.WOOD.getMeta()),
                                                   " x ",
                                                   "xox",
                                                   " x ",
                                                   'x', "stickWood",
                                                   'o', "plankWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ESItems.ITEM_MATERIAL_GEAR.getStack(1, MaterialGear.STONE.getMeta()),
                                                   " x ",
                                                   "xox",
                                                   " x ",
                                                   'x', "cobblestone",
                                                   'o', "gearWood"));
    }
}
