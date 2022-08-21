package com.crimsonreborn.crimsonutils.item;

import com.crimsonreborn.crimsonutils.CrimsonUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrimsonUtils.MODID);

    public static final RegistryObject<Item> HEARTHSTONE = ITEMS.register("hearthstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));
    public static final RegistryObject<Item> WORLDSTONE = ITEMS.register("worldstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));
    public static final RegistryObject<Item> COINCOPPER = ITEMS.register("coin_copper",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));
    public static final RegistryObject<Item> COINGOLD = ITEMS.register("coin_gold",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));
    public static final RegistryObject<Item> COINSILVER = ITEMS.register("coin_silver",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));
    public static final RegistryObject<Item> GEMCITRINE = ITEMS.register("gem_citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CRIMSONUTILS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
