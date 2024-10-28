package io.github.somehussar.cnpcbukkit.api.essentials;

import com.earth2me.essentials.ChargeException;
import com.earth2me.essentials.User;
import net.ess3.api.MaxMoneyException;

public interface IEssentialsUser {

    void takeMoney(double amount);
    void giveMoney(double amount) throws MaxMoneyException;
    void payUser(String userName, double amount) throws MaxMoneyException, ChargeException;
    void payUser(IEssentialsUser user, double amount) throws MaxMoneyException, ChargeException;
    boolean canAfford(double amount);

    User getEssentialsUserData();
}
