package io.github.somehussar.cnpcbukkit.scripted.essentials;

import com.earth2me.essentials.ChargeException;
import com.earth2me.essentials.User;
import io.github.somehussar.cnpcbukkit.api.AbstractPluginAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsUser;
import net.ess3.api.MaxMoneyException;
import noppes.npcs.api.AbstractNpcAPI;
import noppes.npcs.api.entity.IPlayer;

import java.math.BigDecimal;

public class ScriptEssentialsUser implements IEssentialsUser {

    private final User essentialsUser;

    public ScriptEssentialsUser(User essentialsUser) {
        this.essentialsUser = essentialsUser;
    }

    @Override
    public void takeMoney(double amount) {
        takeMoneyExact(BigDecimal.valueOf(amount));
    }

    @Override
    public void giveMoney(double amount) throws MaxMoneyException {
        giveMoneyExact(BigDecimal.valueOf(amount));
    }

    @Override
    public void setMoney(double amount) throws MaxMoneyException {
        setMoneyExact(BigDecimal.valueOf(amount));
    }

    @Override
    public void payUser(String userName, double amount) throws MaxMoneyException, ChargeException {
        IEssentialsAPI API = AbstractPluginAPI.getInstance().getEssentialsAPI();
        this.payUser(API.getUser(userName), amount);
    }

    @Override
    public void payUser(IEssentialsUser user, double amount) throws MaxMoneyException, ChargeException {
        this.payUserExact(user, BigDecimal.valueOf(amount));
    }

    @Override
    public void payUser(IPlayer player, double amount) throws MaxMoneyException, ChargeException {
        this.payUser(player.getName(), amount);
    }

    @Override
    public void payUserExact(String userName, BigDecimal amount) throws MaxMoneyException, ChargeException {
        IEssentialsAPI API = AbstractPluginAPI.getInstance().getEssentialsAPI();
        this.payUserExact(API.getUser(userName), amount);
    }

    @Override
    public void payUserExact(IEssentialsUser user, BigDecimal amount) throws MaxMoneyException, ChargeException {
        essentialsUser.payUser(user.getEssentialsUserData(), amount);
    }

    @Override
    public void payUserExact(IPlayer player, BigDecimal amount) throws MaxMoneyException, ChargeException {
        this.payUserExact(player.getName(), amount);
    }

    @Override
    public boolean canAfford(double amount) {
        return essentialsUser.canAfford(new BigDecimal(amount));
    }

    @Override
    public double getMoney() {
        return getMoneyExact().doubleValue();
    }

    @Override
    public void takeMoneyExact(BigDecimal amount) {
        essentialsUser.takeMoney(amount);
    }

    @Override
    public void giveMoneyExact(BigDecimal amount) throws MaxMoneyException {
        essentialsUser.giveMoney(amount);
    }

    @Override
    public void setMoneyExact(BigDecimal amount) throws MaxMoneyException {
        essentialsUser.setMoney(amount);
    }

    @Override
    public boolean canAffordExact(BigDecimal amount) {
        return essentialsUser.canAfford(amount);
    }

    @Override
    public BigDecimal getMoneyExact() {
        return essentialsUser.getMoney();
    }

    @Override
    public User getEssentialsUserData() {
        return this.essentialsUser;
    }

    @Override
    public IPlayer getCNPCPlayer() {
        return AbstractNpcAPI.Instance().getPlayer(essentialsUser.getName());
    }

    @Override
    public boolean isOnline() {
        return essentialsUser.getBase().isOnline();
    }
}
