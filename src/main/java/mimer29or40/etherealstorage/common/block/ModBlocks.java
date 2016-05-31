package mimer29or40.etherealstorage.common.block;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.block.material.BlockMaterialBlock;
import mimer29or40.etherealstorage.common.block.material.BlockMaterialOre;
import mimer29or40.etherealstorage.common.item.material.ItemBlockMaterialBlock;
import mimer29or40.etherealstorage.common.item.material.ItemBlockMaterialOre;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ModBlocks
{
    private static List<BlockBase> blocks = new ArrayList<>();

    public static BlockMaterialBlock blockMaterialBlock;
    public static BlockMaterialOre   blockMaterialOre;

    public static void registerBlocks()
    {
        blockMaterialBlock = registerBlock(BlockMaterialBlock.class, ItemBlockMaterialBlock.class);
        blockMaterialOre = registerBlock(BlockMaterialOre.class, ItemBlockMaterialOre.class);
    }

    private static <Block extends BlockBase> Block registerBlock(Class<Block> blockClass)
    {
        return registerBlock(blockClass, ItemBlock.class);
    }

    private static <Block extends BlockBase> Block registerBlock(Class<Block> blockClass, Class<? extends ItemBlock> itemBlockClass)
    {
        Block block = null;
        try
        {
            block = blockClass.getConstructor().newInstance();
            ItemBlock itemBlock = itemBlockClass.getConstructor(net.minecraft.block.Block.class).newInstance(block);

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

            blocks.add(block);
            Log.info(String.format("Registered block (%s)", block.getClass().getCanonicalName()));
        }
        catch (Exception e)
        {
            Log.fatal(String.format("Fatal Error while registering block (%s)", block.getClass().getCanonicalName()));
            e.printStackTrace();
        }

        return block;
    }

    public static List<BlockBase> getBlocks()
    {
        return Collections.unmodifiableList(blocks);
    }
}
