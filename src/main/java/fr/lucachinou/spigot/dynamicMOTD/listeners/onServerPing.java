package fr.lucachinou.spigot.dynamicMOTD.listeners;

import fr.lucachinou.spigot.dynamicMOTD.DynamicMOTD;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class onServerPing implements Listener {
    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd(DynamicMOTD.getCurrentMotd());

        if (DynamicMOTD.Maintenance) {
            event.setMaxPlayers(0);
        }
    }
}
