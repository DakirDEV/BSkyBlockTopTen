package net.hexxcraft.bskyblocktopten;

import net.hexxcraft.bskyblocktopten.commands.BSBTopTen;
import net.hexxcraft.bskyblocktopten.events.BlockBreak;
import net.hexxcraft.bskyblocktopten.events.PlayerInteract;
import net.hexxcraft.bskyblocktopten.events.SignChange;
import net.hexxcraft.bskyblocktopten.files.ConfigFile;
import net.hexxcraft.bskyblocktopten.files.MessagesFile;
import net.hexxcraft.bskyblocktopten.files.SignFile;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import net.hexxcraft.bskyblocktopten.taks.TopTenReload;
import net.hexxcraft.bskyblocktopten.utils.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BSkyBlockTopTen extends JavaPlugin {

    private ConfigFile configFile;
    private MessagesFile messagesFile;
    private Messages messages;
    private SkullAPI skullAPI;
    private SignAPI signAPI;
    private TopTenAPI topTenAPI;
    private TopTenReload topTenReload;
    private List<TopTenSign> topTenSigns;
    private SignFile signFile;

    @Override
    public void onEnable() {
        configFile = new ConfigFile(this);
        configFile.load();

        messages = new Messages();
        messagesFile = new MessagesFile(this);
        messagesFile.load();

        skullAPI = new SkullAPI(this);
        signAPI = new SignAPI(this);
        topTenAPI = new TopTenAPI(this);

        topTenReload = new TopTenReload(this);
        topTenReload.start();

        topTenSigns = new ArrayList<TopTenSign>();

        signFile = new SignFile(this);
        signFile.loadData();

        registerCommands();
        registerEvents();

        getLogger().info("Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled!");
    }

    private void registerCommands() {
        getServer().getPluginCommand("bsbtopten").setExecutor(new BSBTopTen(this));
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
        getServer().getPluginManager().registerEvents(new SignChange(this), this);
    }

    public Messages getMessages() {
        return messages;
    }

    public SkullAPI getSkullAPI() {
        return skullAPI;
    }

    public SignAPI getSignAPI() {
        return signAPI;
    }

    public TopTenAPI getTopTenAPI() {
        return topTenAPI;
    }

    public List<TopTenSign> getTopTenSigns() {
        return topTenSigns;
    }

    public SignFile getSignFile() {
        return signFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public MessagesFile getMessagesFile() {
        return messagesFile;
    }
}
