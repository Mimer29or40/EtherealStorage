package mimer29or40.etherealstorage.proxy;

import java.io.File;

public interface IProxy
{
    /**
     * Register Blocks
     */
    void registerBlocks();

    /**
     * Register Items
     */
    void registerItems();

    /**
     * Register Ore Dictionary
     */
    void registerOreDict();

    /**
     * Register Furnace Recipes
     */
    void registerFurnaceRecipes();

    /**
     * Register Crusher Recipes
     */
    void registerCrusherRecipes();

    /**
     * Register Recipes
     */
    void registerRecipes();

    /**
     * Register Events
     */
    void registerEvents();

    /**
     * Register GUIs
     */
    void registerGUIs();

    void registerRenderers();

    void registerWorldGen();

    void registerConfiguration(File configFile);

    void registerFluids();
}
