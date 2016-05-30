package mimer29or40.etherealstorage.common.material;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MaterialMetal implements IStringSerializable
{
    // Vanilla
    IRON("Iron", 0, Type.NUGGET, Type.DUST, Type.FLUID),
    GOLD("Gold", 1, Type.DUST, Type.FLUID),

    // Natural
    COPPER("Copper", 2, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    TIN("Tin", 3, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    SILVER("Silver", 4, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    LEAD("Lead", 5, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    NICKEL("Nickel", 6, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    PLATINUM("Platinum", 7, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    MITHRIL("Mithril", 8, Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),

    // Alloy
//    BRONZE("Bronze", 9),
//    INVAR("Invar", 10),
//    ELECTRUM("Electrum", 11),
    ;

    private final String name;
    private final int    meta;
    private final Type[] materialTypeList;

    private static final MaterialMetal[] META_LOOKUP = new MaterialMetal[values().length];

    static
    {
        for (MaterialMetal metal : values())
        { META_LOOKUP[metal.getMeta()] = metal; }
    }

    MaterialMetal(String name, int meta, Type... materialTypes)
    {
        this.name = name;
        this.meta = meta;
        this.materialTypeList = materialTypes;
    }

    public static MaterialMetal byMeta(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public static List<MaterialMetal> byType(Type type)
    {
        List<MaterialMetal> result = new ArrayList<>();

        for (MaterialMetal ore : values())
        {
            if (ore.isTypeSet(type))
            {
                result.add(ore);
            }
        }

        return result;
    }

    public int getMeta()
    {
        return this.meta;
    }

    public String getUnlocalizedName()
    {
        return this.name.toLowerCase();
    }

    public String getName()
    {
        return this.name.toLowerCase();
    }

    public String getMetalName()
    {
        return this.name;
    }

    public String toString()
    {
        return getName();
    }

    public boolean isTypeSet(Type enumOreType)
    {
        return Arrays.asList(materialTypeList).contains(enumOreType);
    }

    public enum Type
    {
        ORE, INGOT, NUGGET, DUST, BLOCK, FLUID
    }
}
