package net.hexxcraft.bskyblocktopten.taks;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.Bukkit;

public class TopTenReload {
    private BSkyBlockTopTen plugin;

    public TopTenReload(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    public void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                plugin.getTopTenAPI().setTopTenList(plugin.getTopTenAPI().getTopTen());
                plugin.getSignAPI().updateSigns();
            }
        }, 20L, 20L*10);
    }
}
