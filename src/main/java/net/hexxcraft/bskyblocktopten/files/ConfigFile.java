package net.hexxcraft.bskyblocktopten.files;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {
    private BSkyBlockTopTen plugin;

    private File configFile;
    private FileConfiguration config;

    public ConfigFile(BSkyBlockTopTen plugin) {
        this.plugin = plugin;

        configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = new YamlConfiguration();

        try {
            config.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        addDefaults();

        load();
    }

    public void addDefaults() {
        config.options().copyDefaults(true);

        config.addDefault("sign-refresh-interval", 30);
        config.addDefault("command-on-sign-right-click", "is top");
        config.addDefault("skyblock-world-name", "bskyblock_world");

        try {
            config.save(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        config = new YamlConfiguration();

        try {
            config.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
