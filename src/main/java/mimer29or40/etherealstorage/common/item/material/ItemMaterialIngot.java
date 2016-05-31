package mimer29or40.etherealstorage.common.item.material;

import mimer29or40.etherealstorage.EtherealStorageCreativeTabs;
import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.block.ModBlocks;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.item.ModItems;
import mimer29or40.etherealstorage.common.material.MaterialMetal;
import mimer29or40.etherealstorage.common.registry.IRegisterFurnaceRecipe;
import mimer29or40.etherealstorage.common.registry.IRegisterRecipe;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.List;

public class ItemMaterialIngot extends ItemBase implements IRegisterRecipe, IRegisterFurnaceRecipe
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
        String metalName = MaterialMetal.byMeta(stack.getItemDamage()).getName();
        return name + "." + metalName;
    }

    @Override
    public void registerItemModel()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            if (metal.isTypeSet(MaterialMetal.Type.INGOT))
            {
                ModelLoader.setCustomModelResourceLocation(this, metal.getMeta(), new ModelResourceLocation(
                        ModInfo.MOD_ID + ":material/ingot/ingot_" + metal.getName(), "inventory"));
            }
        }
    }

    @Override
    public void registerRecipes()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            String metalName = metal.getActualName();

            if (metal.isTypeSet(MaterialMetal.Type.INGOT, MaterialMetal.Type.BLOCK))
            { GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.itemMaterialIngot.getStack(9, metal.getMeta()), "block" + metalName)); }

            if (metal.isTypeSet(MaterialMetal.Type.INGOT, MaterialMetal.Type.NUGGET))
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.itemMaterialIngot.getStack(1, metal.getMeta()),
                                                           "xxx",
                                                           "xxx",
                                                           "xxx",
                                                           'x', "nugget" + metalName));
            }
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(Items.IRON_INGOT,
                                                   "xxx",
                                                   "xxx",
                                                   "xxx",
                                                   'x', "nuggetIron"));
    }

    @Override
    public void registerFurnaceRecipes()
    {
        for (MaterialMetal metal : MaterialMetal.values())
        {
            String metalName = metal.getActualName();

            if (metal.isTypeSet(MaterialMetal.Type.INGOT, MaterialMetal.Type.ORE))
            {
                GameRegistry.addSmelting(ModBlocks.blockMaterialOre.getStack(1, metal.getMeta()),
                                         ModItems.itemMaterialIngot.getStack(1, metal.getMeta()), 0.7F);
            }

            if (metal.isTypeSet(MaterialMetal.Type.INGOT, MaterialMetal.Type.DUST))
            {
                GameRegistry.addSmelting(ModItems.itemMaterialDust.getStack(1, metal.getMeta()),
                                         ModItems.itemMaterialIngot.getStack(1, metal.getMeta()), 0.7F);
            }
        }

        GameRegistry.addSmelting(ModItems.itemMaterialDust.getStack(1, MaterialMetal.IRON.getMeta()), new ItemStack(Items.IRON_INGOT, 1), 0.7F);
        GameRegistry.addSmelting(ModItems.itemMaterialDust.getStack(1, MaterialMetal.GOLD.getMeta()), new ItemStack(Items.GOLD_INGOT, 1), 0.7F);
    }
}
