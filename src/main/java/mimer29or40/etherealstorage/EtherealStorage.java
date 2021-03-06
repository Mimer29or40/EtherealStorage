package mimer29or40.etherealstorage;

import com.google.common.base.Stopwatch;
import mimer29or40.etherealstorage.common.config.Config;
import mimer29or40.etherealstorage.common.util.Log;
import mimer29or40.etherealstorage.proxy.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, certificateFingerprint = ModInfo.FINGERPRINT, dependencies = ModInfo.DEPENDENCIES, version =
        ModInfo.VERSION_BUILD, guiFactory = ModInfo.GUI_FACTORY)
public class EtherealStorage
{
    @Mod.Instance(ModInfo.MOD_ID)
    public static EtherealStorage instance;

    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static Configuration configuration;

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Log.info("Pre Initialization (Started)");

        //Make sure we are running on java 7 or newer
//        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_7))
//        {
//            throw new OutdatedJavaException(String.format("%s requires Java 7 or newer, Please update your java", ModInfo.MOD_NAME));
//        }

        proxy.registerConfiguration(event.getSuggestedConfigurationFile());

//        PacketHandler.init();

        proxy.registerBlocks();

        proxy.registerItems();

        proxy.registerFluids();

        proxy.registerOreDict();

        proxy.registerGUIs();

        proxy.registerEvents();

        proxy.registerRenderers();

        proxy.registerWorldGen();

//        IntegrationsManager.instance().index();
//        IntegrationsManager.instance().preInit();

        Log.info("Pre Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Log.info("Initialization (Started)");

        proxy.registerRecipes();

        proxy.registerCrusherRecipes();

        proxy.registerFurnaceRecipes();

//        WorldGen worldGen = new WorldGen();
//        GameRegistry.registerWorldGenerator(worldGen, 0);
//        MinecraftForge.EVENT_BUS.register(worldGen);

        MinecraftForge.EVENT_BUS.register(this);

        // Init Integrations
//        IntegrationsManager.instance().init();

        Log.info("Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Log.info("Post Initialization (Started)");

//        IntegrationsManager.instance().postInit();

        Map<String, Fluid> fluids = FluidRegistry.getRegisteredFluids();
        for (String key : fluids.keySet())
        {
            Fluid fluid = fluids.get(key);
            Log.info(">>> Fluid Name: %s (%s)", key, fluid.getUnlocalizedName());
        }

        for (String oreName : OreDictionary.getOreNames())
        {
            Log.info(">>> OreDic Name: %s", oreName);
        }

        Log.info("Post Initialization (Ended after " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(ModInfo.MOD_ID))
        {
            Config.loadConfiguration();
        }
    }
}
