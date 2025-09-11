package fr.lucachinou.spigot.dynamicMOTD;

import fr.lucachinou.spigot.dynamicMOTD.listeners.onPostJoinSpigot;
import fr.lucachinou.spigot.dynamicMOTD.listeners.onServerPing;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

public class DynamicMOTD extends JavaPlugin {
    public static String AvailableVersion = "";

    public static String News = "";

    public static String MajorUpdate = "";

    public static Boolean Maintenance = true;

    private File configFile;

    public static FileConfiguration config;

    public static String getCurrentMotd() {
        return "         §2"+ fr.lucachinou.spigot.dynamicMOTD.DynamicMOTD.config.getString("MesageOfTheDayConfig.servername").replace("&", "§") +" §7| "+News+" "+AvailableVersion+"\n"+"         "+MajorUpdate;
    }

    @Override
    public void onEnable() {
        Logger logger = getServer().getLogger();
        this.getCommand("maintenance").setExecutor(new MaintenanceCommandSpigot());
        this.getCommand("description").setExecutor(new descriptionCommandSpigot());
        getServer().getPluginManager().registerEvents(new onPostJoinSpigot(), this);
        getServer().getPluginManager().registerEvents(new onServerPing(), this);
        logger.info("Plugin successfully loaded!");
    }

    public void loadConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }

            configFile = new File(getDataFolder(), "config.yml");

            if (!configFile.exists()) {
                saveResource("config.yml", false);
            }

            config = YamlConfiguration.loadConfiguration(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        Logger logger = getServer().getLogger();
        logger.info("Plugin successfully unloaded!");
    }
}
