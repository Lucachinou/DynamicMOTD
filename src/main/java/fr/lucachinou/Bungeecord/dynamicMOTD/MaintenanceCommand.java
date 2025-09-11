package fr.lucachinou.Bungeecord.dynamicMOTD;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import static fr.lucachinou.Bungeecord.dynamicMOTD.DynamicMOTD.Maintenance;

public class MaintenanceCommand extends Command {
    public MaintenanceCommand() {
        super("maintenance", "dynamicmotd.maintenance.manage");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("toggle")) {
                Maintenance = !Maintenance;
                sender.sendMessage("§7Maintenance is now set to §l"+(Maintenance? "enabled":"disabled"));
            }
        } else {
            sender.sendMessage("§cSyntax error! §8§l(/maintenance <value>)");
        }
    }
}
