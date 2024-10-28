package io.github.somehussar.cnpcbukkit.scripted;

import io.github.somehussar.cnpcbukkit.api.AbstractPluginAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.scripted.essentials.ScriptEssentialAPI;
import noppes.npcs.scripted.CustomNPCsException;

public class PluginAPI extends AbstractPluginAPI {
    @Override
    public IEssentialsAPI getEssentialsAPI() throws CustomNPCsException {
        return ScriptEssentialAPI.getInstance();
    }
}
