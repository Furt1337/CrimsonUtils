package com.crimsonreborn.crimsonutils;

import com.crimsonreborn.crimsonutils.block.ModBlocks;
import com.crimsonreborn.crimsonutils.item.ModItems;
import com.crimsonreborn.crimsonutils.utilities.config.Config;
import com.crimsonreborn.crimsonutils.world.feature.ModConfiguredFeatures;
import com.crimsonreborn.crimsonutils.world.feature.ModPlacedFeatures;
import com.crimsonreborn.mexdb.MexDB;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.io.File;

/**
 * Created by Furt on 08/21/2022
 */
@Mod(CrimsonUtils.MODID)
public class CrimsonUtils {
    public static final String MODID = "crimsonutils";
    public static final String VERSION = "0.0.2-1.19.2";
    public static final String MOD_LOADER = "forge";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static Config config;

    public static final File MOD_DIR = new File("config/crimsonutils");
    public static final File INSTANCE_DATA_DIR = new File("crimsonutils_data");

    public static MexDB WAYPOINT_DB;

    public CrimsonUtils() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        WAYPOINT_DB = new MexDB(INSTANCE_DATA_DIR.toString(), "waypoint");
        WAYPOINT_DB.autopush(true);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
