package mimer29or40.etherealstorage.common.registry;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.block.BlockBase;
import mimer29or40.etherealstorage.common.item.ItemBase;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Locale;

public class RegistrationHelper
{
    public static Block registerBlock(Class<? extends Block> blockClass)
    {
        return registerBlock(blockClass, ItemBlock.class);
    }

    public static Block registerBlock(Class<? extends Block> blockClass, Class<? extends ItemBlock> itemBlockClass)
    {
        Block block = null;
        ItemBlock itemBlock;
        String internalName;

        try
        {
            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);

            internalName = ((BlockBase) block).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
            { throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName)); }

            if (internalName.isEmpty())
            { throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", blockClass.getCanonicalName())); }

            block.setRegistryName(ModInfo.MOD_ID, internalName);
            block.setUnlocalizedName(internalName);
            itemBlock.setRegistryName(block.getRegistryName());

            GameRegistry.register(block);
            GameRegistry.register(itemBlock);

            if (block instanceof IRegisterBlockRenderer && Platform.isClient())
            {
                ((IRegisterBlockRenderer) block).registerBlockRenderer();
                ((IRegisterBlockRenderer) block).registerBlockItemRenderer();
            }

            Log.info(String.format("Registered block (%s)", blockClass.getCanonicalName()));
        }
        catch (Exception ex)
        {
            Log.fatal(String.format("Fatal Error while registering block (%s)", blockClass.getCanonicalName()));
            ex.printStackTrace();
        }

        return block;
    }

    public static Item registerItem(Class<? extends Item> itemClass)
    {
        Item item = null;
        String internalName;

        try
        {
            item = itemClass.getConstructor().newInstance();

            internalName = ((ItemBase) item).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
            { throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName)); }

            if (internalName.isEmpty())
            { throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", itemClass.getCanonicalName())); }

            item.setRegistryName(ModInfo.MOD_ID, internalName);
            item.setUnlocalizedName(internalName);

            GameRegistry.register(item);

            if (item instanceof IRegisterItemRenderer && Platform.isClient())
            {
                ((IRegisterItemRenderer) item).registerItemRenderer();
            }

            Log.info(String.format("Registered item (%s)", itemClass.getCanonicalName()));
        }
        catch (Exception ex)
        {
            Log.fatal(String.format("Fatal Error while registering item (%s)", itemClass.getCanonicalName()));
            ex.printStackTrace();
        }

        return item;
    }
}
