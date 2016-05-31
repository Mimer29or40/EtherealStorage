package mimer29or40.etherealstorage.common.item;

import mimer29or40.etherealstorage.ModInfo;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialDust;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialGear;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialIngot;
import mimer29or40.etherealstorage.common.item.material.ItemMaterialNugget;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.common.util.Platform;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ModItems
{
    private static List<ItemBase> items = new ArrayList<>();

    public static ItemMaterialIngot  itemMaterialIngot;
    public static ItemMaterialNugget itemMaterialNugget;
    public static ItemMaterialDust   itemMaterialDust;

    public static ItemMaterialGear itemMaterialGear;

    public static void registerItems()
    {
        itemMaterialIngot = registerItem(ItemMaterialIngot.class);
        itemMaterialNugget = registerItem(ItemMaterialNugget.class);
        itemMaterialDust = registerItem(ItemMaterialDust.class);

        itemMaterialGear = registerItem(ItemMaterialGear.class);
    }

    private static <Item extends ItemBase> Item registerItem(Class<Item> itemClass)
    {
        Item item = null;
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
                item.registerItemModel();
            }

            items.add(item);
            Log.info(String.format("Registered item (%s)", item.getClass().getCanonicalName()));
        }
        catch (Exception e)
        {
            Log.fatal(String.format("Fatal Error while registering item (%s)", item.getClass().getCanonicalName()));
            e.printStackTrace();
        }

        return item;
    }

    public static List<ItemBase> getItems()
    {
        return Collections.unmodifiableList(items);
    }
}
