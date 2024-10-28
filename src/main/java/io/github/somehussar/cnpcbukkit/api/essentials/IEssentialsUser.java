package io.github.somehussar.cnpcbukkit.api.essentials;

import com.earth2me.essentials.ChargeException;
import com.earth2me.essentials.User;
import net.ess3.api.MaxMoneyException;
import noppes.npcs.api.entity.IPlayer;

import java.math.BigDecimal;

public interface IEssentialsUser {

    void takeMoney(double amount);
    void giveMoney(double amount) throws MaxMoneyException;
    void setMoney(double amount) throws MaxMoneyException;
    boolean canAfford(double amount);
    double getMoney();

    void takeMoneyExact(BigDecimal amount);
    void giveMoneyExact(BigDecimal amount) throws MaxMoneyException;
    void setMoneyExact(BigDecimal amount) throws MaxMoneyException;
    boolean canAffordExact(BigDecimal amount);
    BigDecimal getMoneyExact();

    void payUser(String userName, double amount) throws MaxMoneyException, ChargeException;
    void payUser(IEssentialsUser user, double amount) throws MaxMoneyException, ChargeException;
    void payUser(IPlayer player, double amount) throws MaxMoneyException, ChargeException;

    void payUserExact(String userName, BigDecimal amount) throws MaxMoneyException, ChargeException;
    void payUserExact(IEssentialsUser user, BigDecimal amount) throws MaxMoneyException, ChargeException;
    void payUserExact(IPlayer player, BigDecimal amount) throws MaxMoneyException, ChargeException;



    User getEssentialsUserData();
}
