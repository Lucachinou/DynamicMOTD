package fr.lucachinou.Bungeecord.dynamicMOTD.Listener;

import fr.lucachinou.Bungeecord.dynamicMOTD.DynamicMOTD;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnProxyPing implements Listener {
    @EventHandler
    public void onProxyPing(ProxyPingEvent event) {
        ServerPing ping = event.getResponse();
        ping.setDescriptionComponent(new TextComponent(DynamicMOTD.getCurrentMotd()));

        if (DynamicMOTD.Maintenance) {
            ServerPing.Players players = ping.getPlayers();
            players.setSample(new ServerPing.PlayerInfo[] {
                    new ServerPing.PlayerInfo(DynamicMOTD.config.getString("Message.server-ping-maintenance").replace("&", "§"), "MaintenanceStatus")
            });
            ping.setPlayers(players);
        }
        event.setResponse(ping);
    }
}
