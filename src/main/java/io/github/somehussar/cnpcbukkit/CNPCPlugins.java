package io.github.somehussar.cnpcbukkit;

import io.github.somehussar.cnpcbukkit.api.AbstractPluginAPI;
import noppes.npcs.api.AbstractNpcAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class CNPCPlugins extends JavaPlugin {
    @Override
    public void onEnable() {

        try {
            Class.forName("noppes.npcs.api.AbstractNpcAPI");
            AbstractNpcAPI.Instance().addGlobalObject("PluginAPI", AbstractPluginAPI.getInstance());
        } catch (Exception ignored) {

        }
    }

    @Override
    public void onDisable() {

    }
}
