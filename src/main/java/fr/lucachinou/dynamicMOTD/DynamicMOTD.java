package fr.lucachinou.dynamicMOTD;

import fr.lucachinou.dynamicMOTD.Listener.OnPostJoin;
import fr.lucachinou.dynamicMOTD.Listener.OnProxyPing;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public final class DynamicMOTD extends Plugin implements Listener {

    public static String AvailableVersion = "";

    public static String News = "";

    public static String MajorUpdate = "";

    public static Boolean Maintenance = true;

    private File configFile;

    public static Configuration config;

    public static String getCurrentMotd() {
        return "         §2"+ DynamicMOTD.config.getString("MesageOfTheDayConfig.servername").replace("&", "§") +" §7| "+News+" "+AvailableVersion+"\n"+"         "+MajorUpdate;
    }

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getLogger().info("[DynamicsMOTD] loading...");
        loadConfig();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new MOTDCommand());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new MaintenanceCommand());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new OnPostJoin());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new OnProxyPing());
        ProxyServer.getInstance().getLogger().info("[DynamicsMOTD] Successfully loaded!");
    }

    public void loadConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }

            configFile = new File(getDataFolder(), "config.yml");

            if (!configFile.exists()) {
                try (InputStream in = getResourceAsStream("config.yml")) {
                    Files.copy(in, configFile.toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        ProxyServer.getInstance().getLogger().info("[DynamicsMOTD] Disabled!");
    }
}
