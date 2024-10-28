package io.github.somehussar.cnpcbukkit.api;

import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.scripted.PluginAPI;

public abstract class AbstractPluginAPI {

    private static AbstractPluginAPI instance;

    public static AbstractPluginAPI getInstance() {
        if (instance == null)
            instance = new PluginAPI();
        return instance;
    }

    public abstract IEssentialsAPI getEssentialsAPI();
}
