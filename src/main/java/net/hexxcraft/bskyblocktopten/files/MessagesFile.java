package net.hexxcraft.bskyblocktopten.files;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesFile {
    private BSkyBlockTopTen plugin;

    private File configFile;
    private FileConfiguration messagesConfig;

    public MessagesFile(BSkyBlockTopTen plugin) {
        this.plugin = plugin;

        configFile = new File(plugin.getDataFolder(), "messages.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        messagesConfig = new YamlConfiguration();

        try {
            messagesConfig.load(new File(plugin.getDataFolder(), "messages.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        addDefaults();

        load();
    }

    public void addDefaults() {
        messagesConfig.options().copyDefaults(true);

        messagesConfig.addDefault("prefix", "&8[&aBSBTopTen&8] &f");
        messagesConfig.addDefault("onlyPlayer", "You're not a player!");
        messagesConfig.addDefault("reload", "Files were reloaded!");
        messagesConfig.addDefault("noPermission", "&cYou have no permission for that!");
        messagesConfig.addDefault("signCreated", "TopTen sign was &asuccessfully &fcreated!");
        messagesConfig.addDefault("signRemoved", "TopTen sign was &asuccessfully &fremoved!");
        messagesConfig.addDefault("pressShiftKey", "&cHold down the shift key to remove the TopTen sign!");
        messagesConfig.addDefault("signLine1", "&1%place%. Place");
        messagesConfig.addDefault("signLine2", "&f%name%");
        messagesConfig.addDefault("signLine3", "&aLevel %level%");
        messagesConfig.addDefault("signLine4", "&f&f» &0&oRight click &f«");

        try {
            messagesConfig.save(new File(plugin.getDataFolder(), "messages.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        messagesConfig = new YamlConfiguration();

        try {
            messagesConfig.load(new File(plugin.getDataFolder(), "messages.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        plugin.getMessages().prefix = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("prefix"));
        plugin.getMessages().onlyPlayer = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("onlyPlayer"));
        plugin.getMessages().reload = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("reload"));
        plugin.getMessages().noPermission = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("noPermission"));
        plugin.getMessages().signCreated = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signCreated"));
        plugin.getMessages().signRemoved = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signRemoved"));
        plugin.getMessages().pressShiftKey = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("pressShiftKey"));
        plugin.getMessages().signLine1 = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signLine1"));
        plugin.getMessages().signLine2 = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signLine2"));
        plugin.getMessages().signLine3 = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signLine3"));
        plugin.getMessages().signLine4 = ChatColor.translateAlternateColorCodes('&', messagesConfig.getString("signLine4"));
    }
}
