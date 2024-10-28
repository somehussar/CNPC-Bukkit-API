package io.github.somehussar.cnpcbukkit.api;

import io.github.somehussar.cnpcbukkit.api.essentials.IEssentialsAPI;
import io.github.somehussar.cnpcbukkit.scripted.PluginAPI;
import noppes.npcs.scripted.CustomNPCsException;

/**
 * Plugin API exposing certain API functions to be available in scripts. <br>
 * Accessible through <code>PluginAPI</code> <br>
 * <br>
 * Example:
 * <pre>
 * {@code
 * // This CAN throw an error if Essentials is not present on the server.
 * var EssAPI = PluginAPI.getEssentialsAPI();
 *
 * function interact(event) {
 *     var player1 = EssAPI.getUser("Hussar"); // This approach works by player name, and can acquire even offline players.
 *     var player2 = EssAPI.getUser(event.player); // Scripted Player object. Acquired from events.
 *     var player3 = EssAPI.getUser(API.getPlayer("Hussar")); // This approach only works on online players.
 *
 *     var npc = event.npc;
 *     if (player2.canAfford(1000) && player2.isOnline()) {
 *         var dbcPlayer = player2.getCNPCPlayer().getDBCPlayer();
 *         player2.takeMoney(1000);
 *         dbcPlayer.setStat("str", dbcPlayer.getStat("str") + 100);
 *         dbcPlayer.sendMessage("Given you 100 STR for $1000");
 *     } else {
 *         npc.say("bruh");
 *     }
 * }
 * }
 * </pre>
 */
public abstract class AbstractPluginAPI {

    private static AbstractPluginAPI instance;

    public static AbstractPluginAPI getInstance() {
        if (instance == null)
            instance = new PluginAPI();
        return instance;
    }

    /**
     * @return API Wrapper for the <code>Essentials</code> plugin
     */
    public abstract IEssentialsAPI getEssentialsAPI() throws CustomNPCsException;
}
