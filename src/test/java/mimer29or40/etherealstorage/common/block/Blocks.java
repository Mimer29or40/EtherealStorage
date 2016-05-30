package mimer29or40.etherealstorage.common.block;

import mimer29or40.etherealstorage.common.block.blockmaterial.BlockMetalBlock;
import mimer29or40.etherealstorage.common.item.metal.ItemMetalBlock;
import mimer29or40.etherealstorage.common.registry.RegistrationHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public enum Blocks
{
    BLOCK_METAL_BLOCK(BlockMetalBlock.class, ItemMetalBlock.class);//,
//    BLOCK_ORE_BLOCK(BlockOreBlock.class, ItemOreBlock.class);//,
//    BLOCK_MACHINE_PULVERIZER(BlockPulverizer.class, ItemPulverizer.class),
//    BLOCK_MACHINE_FURNACE(BlockFurnace.class, ItemFurnace.class);

    private final Class<? extends BlockBase> blockClass;
    private final Class<? extends ItemBlock> itemBlockClass;
    private       Block                      block;

    Blocks(Class<? extends BlockBase> blockClass)
    {
        this(blockClass, ItemBlock.class);
    }

    Blocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass)
    {
        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    public static void registerBlocks()
    {
        for (Blocks block : values())
        {
            block.registerBlock();
        }
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

    public Block getBlock()
    {
        return this.block;
    }

    private void registerBlock()
    {
        block = RegistrationHelper.registerBlock(blockClass, itemBlockClass);
    }
}
