package mimer29or40.etherealstorage.common.block;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.block.material.BlockMaterialBlock;
import mimer29or40.etherealstorage.common.block.material.BlockMaterialOre;
import mimer29or40.etherealstorage.common.item.material.ItemBlockMaterialBlock;
import mimer29or40.etherealstorage.common.item.material.ItemBlockMaterialOre;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Locale;

public enum ESBlocks
{
    BLOCK_MATERIAL_ORE(BlockMaterialOre.class, ItemBlockMaterialOre.class),
    BLOCK_MATERIAL_BLOCK(BlockMaterialBlock.class, ItemBlockMaterialBlock.class),;

    private final Class<? extends BlockBase> blockClass;
    private final Class<? extends ItemBlock> itemBlockClass;
    private       BlockBase                  block;

    ESBlocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass)
    {
        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    ESBlocks(Class<? extends BlockBase> blockClass)
    {
        this(blockClass, ItemBlock.class);
    }

    public static void registerBlocks()
    {
        for (ESBlocks blocks : values())
        { blocks.registerBlock(); }
    }

    public ItemStack getStack()
    {
        return new ItemStack(block);
    }

    public ItemStack getStack(int size)
    {
        return new ItemStack(block, size);
    }

    public ItemStack getStack(int size, int meta)
    {
        return new ItemStack(block, size, meta);
    }

    public BlockBase getBlock()
    {
        return this.block;
    }

    private void registerBlock()
    {
        try
        {
            block = blockClass.getConstructor().newInstance();
            ItemBlock itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);

            String internalName = block.getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
            { throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Block: %s", internalName)); }

            if (internalName.isEmpty())
            { throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Block: %s", block.getClass().getCanonicalName())); }

            block.setRegistryName(ModInfo.MOD_ID, internalName);
            block.setUnlocalizedName(internalName);

            itemBlock.setRegistryName(block.getRegistryName());

            GameRegistry.register(block);
            GameRegistry.register(itemBlock);

            if (Platform.isClient())
            {
                block.registerBlockModel();
                block.registerBlockItemModel();
            }

            Log.info(String.format("Registered block (%s)", block.getClass().getCanonicalName()));
        }
        catch (Exception e)
        {
            Log.fatal(String.format("Fatal Error while registering block (%s)", blockClass.getCanonicalName()));
            e.printStackTrace();
        }
    }
}
