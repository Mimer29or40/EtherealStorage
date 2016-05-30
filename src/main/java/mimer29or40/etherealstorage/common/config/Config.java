package mimer29or40.etherealstorage.common.config;

import mimer29or40.etherealstorage.EtherealStorage;
import mimer29or40.etherealstorage.ModInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.io.File;
import java.util.Arrays;

public class Config extends GuiConfig
{
    public static Configuration configuration;

    public static final String CONFIG_GENERAL  = "general";
    public static final String CONFIG_WORLDGEN = "worldgen";

    public Config(GuiScreen parentScreen)
    {
        super(parentScreen,
              Arrays.asList(new IConfigElement[]
                                    {
                                            new ConfigElement(EtherealStorage.configuration.getCategory(CONFIG_GENERAL)),
                                            new ConfigElement(EtherealStorage.configuration.getCategory(CONFIG_WORLDGEN))
                                    }),
              ModInfo.MOD_ID,
              false,
              false,
              "Ethereal Storage Configuration");
        titleLine2 = EtherealStorage.configuration.getConfigFile().getAbsolutePath();
    }

    public static Configuration initConfig(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
        return configuration;
    }

    public static void loadConfiguration()
    {
        ConfigWorldGen.init(configuration);
        configuration.save();
    }
}
