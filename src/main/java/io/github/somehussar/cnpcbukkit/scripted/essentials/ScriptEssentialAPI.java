package io.github.somehussar.cnpcbukkit.scripted.essentials;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsUser;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.scripted.CustomNPCsException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ScriptEssentialAPI implements IEssentialsAPI {
    private static IEssentialsAPI instance;

    private final IEssentials ESSENTIALS;

    public ScriptEssentialAPI(IEssentials ESSENTIALS) {
        this.ESSENTIALS = ESSENTIALS;
    }

    public static IEssentialsAPI getInstance() {
        if(instance != null)
            return instance;


        Plugin essentialsPlugin = Bukkit.getPluginManager().getPlugin("Essentials");

        if (essentialsPlugin instanceof IEssentials) {
            instance = new ScriptEssentialAPI((IEssentials) essentialsPlugin);
        } else {
            throw new CustomNPCsException("Essentials is not present on this server.");
        }

        return instance;
    }

    @Deprecated
    /**
     * Fixes a bug with being unable to pick the correct function overload.
     */
    public IEssentialsUser getUser(Object object) {
        if (object instanceof String)
            return getUser((String) object);
        if (object instanceof IPlayer)
            return getUser((IPlayer) object);
        return null;
    }

    @Override
    public IEssentialsUser getUser(String userName) {
        Player player = Bukkit.getPlayer(userName);
        if (player != null) {
            return new ScriptEssentialsUser(ESSENTIALS.getUser(player));
        }
        User user = ESSENTIALS.getUser(userName);
        if(user != null)
            return new ScriptEssentialsUser(user);
        return null;
    }

    @Override
    public IEssentialsUser getUser(IPlayer player) {
        return getUser(player.getName());
    }

}
