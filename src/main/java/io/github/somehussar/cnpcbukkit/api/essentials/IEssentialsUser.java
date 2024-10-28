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

    /**
     * Sends money from this user to the one provided in the function.
     * @param recipientUserName Username of the player who will receive money.
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money.
     */
    void payUser(String recipientUserName, double amount) throws MaxMoneyException, ChargeException;

    /**
     * Refer to {@link IEssentialsUser#payUser(String, double)}
     * @param recipientUser <code>Essentials</code> User wrapper
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money
     */
    void payUser(IEssentialsUser recipientUser, double amount) throws MaxMoneyException, ChargeException;
    /**
     * Refer to {@link IEssentialsUser#payUser(String, double)}
     * @param recipientPlayer CNPC Player object.
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money
     */
    void payUser(IPlayer recipientPlayer, double amount) throws MaxMoneyException, ChargeException;

    /**
     * Sends money from this user to the one provided in the function. <br>
     * Uses {@link BigDecimal} for accuracy.
     * @param recipientUserName Username of the player who will receive money.
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money.
     */
    void payUserExact(String recipientUserName, BigDecimal amount) throws MaxMoneyException, ChargeException;
    /**
     * Refer to {@link IEssentialsUser#payUserExact(String, BigDecimal)}
     * @param recipientUser <code>Essentials</code> User wrapper
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money
     */
    void payUserExact(IEssentialsUser recipientUser, BigDecimal amount) throws MaxMoneyException, ChargeException;
    /**
     * Refer to {@link IEssentialsUser#payUserExact(String, BigDecimal)}
     * @param recipientPlayer CNPC Player object.
     * @param amount amount to transfer
     * @throws MaxMoneyException Exception thrown if the recipient has too much money.
     * @throws ChargeException Exception thrown if the player doesn't have enough money
     */
    void payUserExact(IPlayer recipientPlayer, BigDecimal amount) throws MaxMoneyException, ChargeException;


    /**
     * <bold>Expert use only. Use it if the API is too limiting.</bold>
     * @return Raw <code>Essentials</code> userdata object.
     */
    User getEssentialsUserData();

    /**
     * @return Gets the CNPC player wrapper.
     */
    IPlayer getCNPCPlayer();

    /**
     * @return True if the player is currently online.
     */
    boolean isOnline();
}
