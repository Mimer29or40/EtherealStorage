package mimer29or40.etherealstorage.common.material;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MaterialMetal implements IStringSerializable
{
    // Vanilla
    IRON("Iron", Type.NUGGET, Type.DUST, Type.FLUID),
    GOLD("Gold", Type.DUST, Type.FLUID),

    // Natural
    COPPER("Copper", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    TIN("Tin", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    SILVER("Silver", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    LEAD("Lead", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    NICKEL("Nickel", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    PLATINUM("Platinum", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),
    MITHRIL("Mithril", Type.INGOT, Type.NUGGET, Type.DUST, Type.ORE, Type.BLOCK, Type.FLUID),

    // Alloy
//    BRONZE("Bronze"),
//    INVAR("Invar"),
//    ELECTRUM("Electrum"),
    ;

    private final String name;
    private final Type[] materialTypeList;

    private static final MaterialMetal[] META_LOOKUP = new MaterialMetal[values().length];

    static
    {
        for (MaterialMetal metal : values())
        { META_LOOKUP[metal.getMeta()] = metal; }
    }

    MaterialMetal(String name, Type... materialTypes)
    {
        this.name = name;
        this.materialTypeList = materialTypes;
    }

    public static MaterialMetal byMeta(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length) meta = 0;

        return META_LOOKUP[meta];
    }

    public static List<MaterialMetal> byType(Type type)
    {
        List<MaterialMetal> result = new ArrayList<>();

        for (MaterialMetal ore : values())
            if (ore.isTypeSet(type))
                result.add(ore);

        return result;
    }

    public int getMeta()
    {
        return ordinal();
    }

    public String getName()
    {
        return this.name.toLowerCase();
    }

    public String getActualName()
    {
        return this.name;
    }

    public String toString()
    {
        return getName();
    }

    public boolean isTypeSet(Type... materialTypes)
    {
        return Arrays.asList(materialTypeList).containsAll(Arrays.asList(materialTypes));
    }

    public enum Type
    {
        ORE, INGOT, NUGGET, DUST, BLOCK, FLUID
    }
}
