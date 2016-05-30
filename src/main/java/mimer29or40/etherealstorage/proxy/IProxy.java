package mimer29or40.etherealstorage.proxy;

import java.io.File;

public interface IProxy
{
    void registerBlocks();

    void registerItems();

    void registerOreDict();

    void registerFurnaceRecipes();

    void registerCrusherRecipes();

    void registerRecipes();

    void registerEvents();

    void registerGUIs();

    void registerRenderers();

    void registerWorldGen();

    void registerConfiguration(File configFile);

    void registerFluids();
}
