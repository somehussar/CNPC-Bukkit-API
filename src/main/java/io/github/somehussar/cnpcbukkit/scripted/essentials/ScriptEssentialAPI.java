package io.github.somehussar.cnpcbukkit.scripted.essentials;

import com.earth2me.essentials.IEssentials;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsUser;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.scripted.CustomNPCsException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ScriptEssentialAPI implements IEssentialsAPI {
    private static IEssentialsAPI instance;

    private IEssentials Essentials;

    public ScriptEssentialAPI(IEssentials essentials) {
    }

    public static IEssentialsAPI getInstance() {
        if(instance != null)
            return instance;


        Plugin essentialsPlugin = Bukkit.getPluginManager().getPlugin("");

        if (essentialsPlugin instanceof IEssentials) {
            instance = new ScriptEssentialAPI((IEssentials) essentialsPlugin);
        } else {
            throw new CustomNPCsException("Essentials is not present on this server.");
        }

        return instance;
    }

    @Override
    public IEssentialsUser getUser(String userName) {
        return null;
    }

    @Override
    public IEssentialsUser getUser(IPlayer player) {
        return getUser(player.getName());
    }

    @Override
    public IEssentialsUser getOfflineUser(String userName) {
        return null;
    }
}
