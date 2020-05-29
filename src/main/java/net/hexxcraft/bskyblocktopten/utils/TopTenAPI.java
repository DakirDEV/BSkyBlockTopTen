package net.hexxcraft.bskyblocktopten.utils;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.Bukkit;
import world.bentobox.bentobox.api.addons.request.AddonRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TopTenAPI {
    private BSkyBlockTopTen plugin;

    private Map<UUID, Long> topTenList;

    public TopTenAPI(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    public Map<UUID, Long> getTopTen() {
        return (Map<UUID, Long>) new AddonRequestBuilder()
                .addon("Level")
                .label("top-ten-level")
                .addMetaData("world-name", plugin.getConfig().getString("skyblock-world-name"))
                .request();
    }

    public void setTopTenList(Map<UUID, Long> topTenList) {
        this.topTenList = topTenList;
    }

    public Map<UUID, Long> getTopTenList() {
        return topTenList;
    }

    public UUID getPlayerUUID(int place) {
        List<UUID> places = new ArrayList(topTenList.keySet());
        return places.get(place - 1);
    }

    public String getPlayerName(int place) {
        return Bukkit.getOfflinePlayer(getPlayerUUID(place)).getName();
    }

    public Long getLevel(int place) {
        return topTenList.get(getPlayerUUID(place));
    }
}
