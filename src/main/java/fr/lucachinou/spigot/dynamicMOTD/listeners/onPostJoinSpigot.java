package fr.lucachinou.spigot.dynamicMOTD.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static fr.lucachinou.spigot.dynamicMOTD.DynamicMOTD.config;

public class onPostJoinSpigot implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (!player.hasPermission("dynamicmotd.maintenance.bypass")) {
                player.kickPlayer(config.getString("Message.non-perm-kick"));
        }
    }
}
