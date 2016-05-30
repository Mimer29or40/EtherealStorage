package mimer29or40.etherealstorage.common.item;

import mimer29or40.etherealstorage.common.item.metal.ItemMetalIngot;
import mimer29or40.etherealstorage.common.registry.RegistrationHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public enum Items
{
    ITEM_METAL_INGOT(ItemMetalIngot.class);

    private final Class<? extends Item> itemClass;
    private       Item                  item;

    Items(Class<? extends Item> itemClass)
    {
        this.itemClass = itemClass;
    }

    public static void registerItems()
    {
        for (ESItems i : ESItems.values())
        {
            i.registerItem();
        }
    }

    public ItemStack getStack()
    {
        return new ItemStack(item);
    }

    public ItemStack getStack(int size)
    {
        return new ItemStack(item, size);
    }

    public ItemStack getStack(int size, int damage)
    {
        return new ItemStack(item, size, damage);
    }

    public Item getItem()
    {
        return this.item;
    }

    private void registerItem()
    {
        item = RegistrationHelper.registerItem(itemClass);
    }
}
