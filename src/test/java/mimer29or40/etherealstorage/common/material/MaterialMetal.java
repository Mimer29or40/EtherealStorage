package mimer29or40.etherealstorage.common.material;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MaterialMetal implements IStringSerializable
{
    //    IRON("Iron", 0, MaterialType.NUGGET, MaterialType.DUST, MaterialType.VANILLA, MaterialType.GEAR, MaterialType.FLUID),
//    GOLD("Gold", 1, MaterialType.NUGGET, MaterialType.DUST, MaterialType.VANILLA, MaterialType.GEAR, MaterialType.FLUID),
    COPPER("Copper", 0, MaterialMetalType.BLOCK, MaterialMetalType.INGOT);

    private static final MaterialMetal[] META_LOOKUP = new MaterialMetal[values().length];

    static
    {
        for (MaterialMetal metal : values())
        { META_LOOKUP[metal.getMeta()] = metal; }
    }

    private final String              name;
    private final int                 meta;
    private final MaterialMetalType[] materialTypeList;

    MaterialMetal(String name, int meta, MaterialMetalType... types)
    {
        this.name = name;
        this.meta = meta;
        this.materialTypeList = types;
    }

    public static MaterialMetal byMeta(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public static List<MaterialMetal> byType(MaterialMetalType type)
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

    public String getOreName()
    {
        return this.name;
    }

    public String toString()
    {
        return getName();
    }

    public boolean isTypeSet(MaterialMetalType enumOreType)
    {
        return Arrays.asList(materialTypeList).contains(enumOreType);
    }
}

