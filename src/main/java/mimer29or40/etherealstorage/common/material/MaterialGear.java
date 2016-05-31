package mimer29or40.etherealstorage.common.material;

import net.minecraft.util.IStringSerializable;

public enum MaterialGear implements IStringSerializable
{
    WOOD("Wood"),
    STONE("Stone"),
    IRON("Iron"),
    GOLD("Gold"),
    COPPER("Copper"),
    TIN("Tin"),
    SILVER("Silver"),
    LEAD("Lead"),
    NICKEL("Nickel"),
    PLATINUM("Platinum"),
    MITHRIL("Mithril"),
//    ALUMINUM("Aluminum"),
//    BRONZE("Bronze"),
//    ELECTRUM("Electrum"),
    ;

    private final String name;

    MaterialGear(String name)
    {
        this.name = name;
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
}
