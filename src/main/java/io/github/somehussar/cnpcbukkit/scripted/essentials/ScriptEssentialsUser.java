package io.github.somehussar.cnpcbukkit.scripted.essentials;

import com.earth2me.essentials.ChargeException;
import com.earth2me.essentials.User;
import io.github.somehussar.cnpcbukkit.api.AbstractPluginAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsUser;
import net.ess3.api.MaxMoneyException;

import java.math.BigDecimal;

public class ScriptEssentialsUser implements IEssentialsUser {

    private final User essentialsUser;

    public ScriptEssentialsUser(User essentialsUser) {
        this.essentialsUser = essentialsUser;
    }

    @Override
    public void takeMoney(double amount) {
        essentialsUser.takeMoney(BigDecimal.valueOf(amount));
    }

    @Override
    public void giveMoney(double amount) throws MaxMoneyException {
        essentialsUser.giveMoney(BigDecimal.valueOf(amount));
    }

    @Override
    public void payUser(String userName, double amount) throws MaxMoneyException, ChargeException {
        IEssentialsAPI API = AbstractPluginAPI.getInstance().getEssentialsAPI();
        this.payUser(API.getUser(userName), amount);
    }

    @Override
    public void payUser(IEssentialsUser user, double amount) throws MaxMoneyException, ChargeException {
        essentialsUser.payUser(user.getEssentialsUserData(), BigDecimal.valueOf(amount));
    }

    @Override
    public boolean canAfford(double amount) {
        return essentialsUser.canAfford(new BigDecimal(amount));
    }

    @Override
    public User getEssentialsUserData() {
        return this.essentialsUser;
    }
}
