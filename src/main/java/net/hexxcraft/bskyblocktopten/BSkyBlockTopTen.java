package net.hexxcraft.bskyblocktopten;

import net.hexxcraft.bskyblocktopten.events.BlockBreak;
import net.hexxcraft.bskyblocktopten.events.PlayerInteract;
import net.hexxcraft.bskyblocktopten.events.SignChange;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import net.hexxcraft.bskyblocktopten.taks.TopTenReload;
import net.hexxcraft.bskyblocktopten.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import world.bentobox.bentobox.api.addons.request.AddonRequestBuilder;
import world.bentobox.bentobox.api.addons.request.AddonRequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BSkyBlockTopTen extends JavaPlugin {

    private Messages messages;
    private SkullAPI skullAPI;
    private SignAPI signAPI;
    private TopTenAPI topTenAPI;
    private TopTenReload topTenReload;
    private List<TopTenSign> topTenSigns;
    private SignFile signFile;

    @Override
    public void onEnable() {
        messages = new Messages();
        skullAPI = new SkullAPI(this);
        signAPI = new SignAPI(this);
        topTenAPI = new TopTenAPI(this);

        topTenReload = new TopTenReload(this);
        topTenReload.start();

        topTenSigns = new ArrayList<TopTenSign>();

        signFile = new SignFile(this);
        signFile.loadData();

        registerEvents();

        getLogger().info("Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled!");
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
}
