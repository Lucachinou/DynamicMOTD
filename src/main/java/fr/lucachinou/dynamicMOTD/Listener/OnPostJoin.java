package fr.lucachinou.dynamicMOTD.Listener;

import fr.lucachinou.dynamicMOTD.DynamicMOTD;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static fr.lucachinou.dynamicMOTD.DynamicMOTD.*;

public class OnPostJoin implements Listener {

    @EventHandler
    public void onPostJoin(PostLoginEvent event) {
        if (Maintenance && !event.getPlayer().hasPermission("dynamicmotd.maintenance.join")) {

            event.getPlayer().disconnect(DynamicMOTD.config.getString("Message.non-perm-kick").replace("&", "§"));
        }
    }
}
