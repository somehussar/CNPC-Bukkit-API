package io.github.somehussar.cnpcbukkit.api.essentials;

import noppes.npcs.api.entity.IPlayer;

public interface IEssentialsAPI {
    IEssentialsUser getUser(String userName);
    IEssentialsUser getUser(IPlayer player);

    IEssentialsUser getOfflineUser(String userName);
}
