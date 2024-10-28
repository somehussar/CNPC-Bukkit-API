package io.github.somehussar.cnpcbukkit.api.essentials;

import noppes.npcs.api.entity.IPlayer;

public interface IEssentialsAPI {
    /**
     * @param userName Username of the player
     * @return Returns <code>Essentials</code> user data. Works even for offline players.
     */
    IEssentialsUser getUser(String userName);

    /**
     * @param player player object.
     * @return Returns <code>Essentials</code> user data. <strong>Works only for online players.</strong>
     */
    IEssentialsUser getUser(IPlayer player);
}
