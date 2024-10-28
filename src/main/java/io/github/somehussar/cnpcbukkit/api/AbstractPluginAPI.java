package io.github.somehussar.cnpcbukkit.api;

import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsUser;
import io.github.somehussar.cnpcbukkit.scripted.PluginAPI;
import io.github.somehussar.cnpcbukkit.scripted.essentials.ScriptEssentialAPI;
import io.github.somehussar.cnpcbukkit.scripted.essentials.ScriptEssentialsUser;

public abstract class AbstractPluginAPI {

    private static AbstractPluginAPI instance;

    public static AbstractPluginAPI getInstance() {
        if (instance == null)
            instance = new PluginAPI();
        return instance;
    }

    public IEssentialsAPI getEssentialsAPI() {
        return ScriptEssentialAPI.getInstance();
    }
}
