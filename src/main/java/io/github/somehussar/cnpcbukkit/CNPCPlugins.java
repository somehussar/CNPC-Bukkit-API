package io.github.somehussar.cnpcbukkit;

import io.github.somehussar.cnpcbukkit.api.AbstractPluginAPI;
import noppes.npcs.api.AbstractNpcAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CNPCPlugins extends JavaPlugin {

    public static Logger logger;

    @Override
    public void onEnable() {
        logger = Logger.getLogger("CustomNPC+ Bukkit Plugin wrapper");
        try {
            Class.forName("noppes.npcs.api.AbstractNpcAPI");
            AbstractNpcAPI.Instance().addGlobalObject("PluginAPI", AbstractPluginAPI.getInstance());
            logger.log(Level.FINE, "Loaded plugin API properly!");
        } catch (Exception ignored) {

        }
    }

    @Override
    public void onDisable() {

    }
}
