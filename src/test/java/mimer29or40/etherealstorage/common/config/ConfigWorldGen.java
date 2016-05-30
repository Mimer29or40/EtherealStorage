package mimer29or40.etherealstorage.common.config;

import net.minecraftforge.common.config.Configuration;

public class ConfigWorldGen
{
//    public static final  Map<EnumOres, OreConfig> OreWorldGen                 = new HashMap<>(EnumOres.values().length);
//    private static final Map<EnumOres, OreConfig> OreWorldGenDefaults         = new HashMap<>(EnumOres.values().length);
//    private static final int[]                    DEFAULT_DIMENSION_BLACKLIST = {-1, 1};

    static
    {
        // Initialize defaults
//        for (EnumOres ore : EnumOres.byType(EnumOreType.ORE))
//        {
//            OreConfig defaultConfig = new OreConfig();
//            defaultConfig.enabled = true;
//            defaultConfig.DimensionRestriction = RestrictionType.BLACKLIST;
//            defaultConfig.dimensions = DEFAULT_DIMENSION_BLACKLIST;
//
//            // Might want to vary this per-ore at some point, but so far it's constant
//            defaultConfig.chunkOccurrence = 20;
//
//            switch (ore)
//            {
//                case COPPER:
//                    defaultConfig.minY = 10;
//                    defaultConfig.maxY = 75;
//                    defaultConfig.veinSize = 16;
//                    defaultConfig.weight = 40;
//                    break;
//
//                case TIN:
//                    defaultConfig.minY = 20;
//                    defaultConfig.maxY = 55;
//                    defaultConfig.veinSize = 10;
//                    defaultConfig.weight = 40;
//                    break;
//
//                case SILVER:
//                    defaultConfig.minY = 5;
//                    defaultConfig.maxY = 30;
//                    defaultConfig.veinSize = 8;
//                    defaultConfig.weight = 20;
//                    break;
//
//                case LEAD:
//                    defaultConfig.minY = 10;
//                    defaultConfig.maxY = 35;
//                    defaultConfig.veinSize = 8;
//                    defaultConfig.weight = 20;
//                    break;
//
//                case NICKEL:
//                    defaultConfig.minY = 5;
//                    defaultConfig.maxY = 60;
//                    defaultConfig.veinSize = 4;
//                    defaultConfig.weight = 20;
//                    break;
//
//                case RUTILE:
//                    defaultConfig.minY = 1;
//                    defaultConfig.maxY = 75;
//                    defaultConfig.veinSize = 20;
//                    defaultConfig.weight = 30;
//                    break;
//            }
//
//            OreWorldGenDefaults.put(ore, defaultConfig);
//        }
    }

    public static void init(Configuration configuration)
    {
        configuration.setCategoryLanguageKey(Config.CONFIG_WORLDGEN, "config.worldGen");
        configuration.setCategoryRequiresWorldRestart(Config.CONFIG_WORLDGEN, false);

        final String WORLDGEN_ORES = String.format("%s.%s", Config.CONFIG_WORLDGEN, "ores");

        final String DESC_ENABLED = "Enable %s in world generation";
        final String DESC_MIN_Y = "Minimum Y-level that %s will spawn at";
        final String DESC_MAX_Y = "Maximum Y-level that %s will spawn at";
        final String DESC_VEIN_SIZE = "Size of %s veins";
        final String DESC_WEIGHT = "Percent chance that %s will generate for each chunk occurrence";
        final String DESC_CHUNK_OCCURRENCE = "Number of times that %s will attempt to generate in each chunk";
        final String DESC_DIM_RESTRICTION = "Either 'blacklist' or 'whitelist'";
        final String DESC_DIM_LIST = "Dimension numbers for restriction";

//        for (EnumOres ore : EnumOres.byType(EnumOreType.ORE))
//        {
//            String oreName = ore.getName();
//            String oreLower = oreName.toLowerCase();
//            String category = String.format("%s.%s", WORLDGEN_ORES, oreName);
//            OreConfig defaultConfig = OreWorldGenDefaults.get(ore);
//
//            OreConfig oreConfig;
//            if (OreWorldGen.containsKey(ore))
//            {
//                // Manipulating the existing config will automatically update WorldGen
//                oreConfig = OreWorldGen.get(ore);
//            }
//            else
//            {
//                oreConfig = new OreConfig();
//            }
//
//            oreConfig.enabled = ConfigHelper.getBoolean(configuration, oreName, WORLDGEN_ORES, defaultConfig.enabled,
//                                                        String.format(DESC_ENABLED, oreLower));
//
//            oreConfig.minY = ConfigHelper.getInteger(configuration, "Min Height", category, defaultConfig.minY, String.format(DESC_MIN_Y,
// oreLower));
//            oreConfig.maxY = ConfigHelper.getInteger(configuration, "Max Height", category, defaultConfig.maxY, String.format(DESC_MAX_Y,
// oreLower));
//            oreConfig.veinSize = ConfigHelper.getInteger(configuration, "Vein Size", category, defaultConfig.veinSize,
//                                                         String.format(DESC_VEIN_SIZE, oreLower));
//            oreConfig.weight = ConfigHelper.getInteger(configuration, "weight", category, defaultConfig.weight, String.format(DESC_WEIGHT,
// oreLower));
//            oreConfig.chunkOccurrence = ConfigHelper.getInteger(configuration, "Chunk Occurrence", category, defaultConfig.chunkOccurrence,
//                                                                String.format(DESC_CHUNK_OCCURRENCE, oreLower));
//
//            String defaultDimRestriction = defaultConfig.DimensionRestriction.name().toLowerCase();
//            String dimRestriction = ConfigHelper.getString(configuration, "Dimension Restriction", category, defaultDimRestriction,
//                                                           DESC_DIM_RESTRICTION);
//            oreConfig.DimensionRestriction = RestrictionType.fromString(dimRestriction, defaultConfig.DimensionRestriction);
//
//            oreConfig.dimensions = ConfigHelper.getIntegerList(configuration, "dimensions", category, defaultConfig.dimensions, DESC_DIM_LIST);
//
//            OreWorldGen.put(ore, oreConfig);
//        }
    }

    public enum RestrictionType
    {
        Blacklist,
        Whitelist;

        public static RestrictionType fromString(String str, RestrictionType def)
        {
            for (RestrictionType rt : values())
            {
                if (rt.name().equalsIgnoreCase(str))
                {
                    return rt;
                }
            }

            return def;
        }
    }

    public static class OreConfig
    {
        public boolean         Enabled;
        public int             MinY;
        public int             MaxY;
        public int             VeinSize;
        public int             Weight;
        public int             ChunkOccurrence;
        public RestrictionType DimensionRestriction;
        public int[]           Dimensions;

        public boolean isEnabledForDim(int dim)
        {
            boolean inList = false;
            for (int listDim : dimensions)
            { inList = inList || listDim == dim; }
            return (inList && DimensionRestriction == RestrictionType.WHITELIST) ||
                   (!inList && DimensionRestriction == RestrictionType.BLACKLIST);
        }
    }
}
