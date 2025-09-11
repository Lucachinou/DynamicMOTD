package fr.lucachinou.spigot.dynamicMOTD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static fr.lucachinou.spigot.dynamicMOTD.DynamicMOTD.Maintenance;

public class MaintenanceCommandSpigot implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] str) {
        Maintenance = !Maintenance;
        sender.sendMessage("§7Maintenance is now set to §l"+(fr.lucachinou.Bungeecord.dynamicMOTD.DynamicMOTD.Maintenance? "enabled":"disabled"));
        return true;
    }
}
