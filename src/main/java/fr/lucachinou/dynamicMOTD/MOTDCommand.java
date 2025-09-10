package fr.lucachinou.dynamicMOTD;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import static fr.lucachinou.dynamicMOTD.DynamicMOTD.*;

public class MOTDCommand extends Command {

    private String repeatChar(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public MOTDCommand() {
        super("description", "dynamicmotd.motd.manage");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("version")) {
                StringBuilder text = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    text.append(args[i]).append(" ");
                }
                AvailableVersion = text.toString().trim().replace("&", "§");
                sender.sendMessage("§7Version availability changed! §8§l("+AvailableVersion+"§8§l)");
            } else if (args[0].equalsIgnoreCase("news")) {
                StringBuilder text = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    text.append(args[i]).append(" ");
                }

                News = text.toString().trim().replace("&", "§");
                sender.sendMessage("§7Server news changed! §8§l("+News+"§8§l)");
            } else if (args[0].equalsIgnoreCase("update")) {
                StringBuilder text = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    text.append(args[i]).append(" ");
                }
                MajorUpdate = text.toString().trim().replace("&", "§");

                int padding = (45 - MajorUpdate.length()) / 2;

                MajorUpdate = repeatChar(' ', Math.max(0, padding)) + MajorUpdate;
                sender.sendMessage("§7Server update changed! §8§l("+MajorUpdate+"§8§l)");
            } else if (args[0].equalsIgnoreCase("get")) {
                sender.sendMessage("§7Current message of the day is: "+getCurrentMotd());
            } else {
                sender.sendMessage("§cSyntax error! §8§l(/description <element> <value>)");
            }
        } else {
            sender.sendMessage("§cSyntax error! §8§l(/description <element> <value>)");
        }
    }
}
