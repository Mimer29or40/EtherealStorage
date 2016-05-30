package mimer29or40.etherealstorage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EtherealStorageCreativeTabs
{
    public static final CreativeTabs tabGeneral = new CreativeTabs(ModInfo.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.IRON_INGOT;//Items.ITEM_TOOL_HAMMER.getItem();
        }

        @Override
        public String getTabLabel()
        {
            return ModInfo.MOD_ID + ".general";
        }
    };

//    public static final CreativeTabs tabOres     = new CreativeTabs(ModInfo.MOD_ID)
//    {
//        @Override
//        public Item getTabIconItem()
//        {
//            return Items.ITEM_ORE_DUST.getItem();
//        }
//
//        @Override
//        public String getTabLabel()
//        {
//            return ModInfo.MOD_ID + ".ores";
//        }
//    };
//
//    public static final CreativeTabs tabMachines = new CreativeTabs(ModInfo.MOD_ID)
//    {
//        @Override
//        public Item getTabIconItem()
//        {
//            return Items.ITEM_MATERIAL_GEAR.getItem();
//        }
//
//        @Override
//        public String getTabLabel()
//        {
//            return ModInfo.MOD_ID + ".machines";
//        }
//    };
//
//    public static final CreativeTabs tabPlans    = new CreativeTabs(ModInfo.MOD_ID)
//    {
//        @Override
//        public Item getTabIconItem()
//        {
//            return Items.ITEM_PLAN.getItem();
//        }
//
//        @Override
//        public String getTabLabel()
//        {
//            return ModInfo.MOD_ID + ".plans";
//        }
//    };
//
//    public static final CreativeTabs tabDebug    = new CreativeTabs(ModInfo.MOD_ID)
//    {
//        @Override
//        public Item getTabIconItem()
//        {
//            return Item.getItemFromBlock(Blocks.command_block);
//        }
//
//        @Override
//        public String getTabLabel()
//        {
//            return ModInfo.MOD_ID + ".debug";
//        }
//
//        @Override
//        public void displayAllRelevantItems(List<ItemStack> itemStackList)
//        {
//            itemStackList.addAll(0, DebugItemHelper.init());
//        }
//    };
//
//    public static final CreativeTabs tabFluids   = new CreativeTabs(ModInfo.MOD_ID)
//    {
//        @Override
//        public Item getTabIconItem()
//        {
//            return net.minecraft.init.Items.bucket;
//        }
//
//        @Override
//        public String getTabLabel()
//        {
//            return ModInfo.MOD_ID + ".fluids";
//        }
//    };

    private EtherealStorageCreativeTabs()
    {

    }
}
