package mimer29or40.etherealstorage.common.item;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialDust;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialGear;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialIngot;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialNugget;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Locale;

public enum ESItems
{
    ITEM_MATERIAL_INGOT(ItemMaterialIngot.class),
    ITEM_MATERIAL_NUGGET(ItemMaterialNugget.class),
    ITEM_MATERIAL_DUST(ItemMaterialDust.class),
    ITEM_MATERIAL_GEAR(ItemMaterialGear.class),;

    private final Class<? extends ItemBase> itemClass;
    private       ItemBase                  item;

    ESItems(Class<? extends ItemBase> itemClass)
    {
        this.itemClass = itemClass;
    }

    public static void registerItems()
    {
        for (ESItems item : values())
        { item.registerItem(); }
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

    public ItemBase getItem()
    {
        return this.item;
    }

    private void registerItem()
    {
        try
        {
            item = itemClass.getConstructor().newInstance();

            String internalName = item.getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
            { throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName)); }

            if (internalName.isEmpty())
            { throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", item.getClass().getCanonicalName())); }

            item.setRegistryName(ModInfo.MOD_ID, internalName);
            item.setUnlocalizedName(internalName);

            GameRegistry.register(item);

            if (Platform.isClient())
            {
                item.registerItemRenderer();
            }

            Log.info(String.format("Registered item (%s)", item.getClass().getCanonicalName()));
        }
        catch (Exception e)
        {
            Log.fatal(String.format("Fatal Error while registering item (%s)", itemClass.getCanonicalName()));
            e.printStackTrace();
        }
    }
}
