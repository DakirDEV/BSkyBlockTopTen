package net.hexxcraft.bskyblocktopten.events;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    private BSkyBlockTopTen plugin;

    public BlockBreak(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (plugin.getSignAPI().isSign(e.getBlock())) {
            Sign sign = (Sign) e.getBlock().getState();
            Location location = sign.getLocation();

            for (int i = 0; i < plugin.getTopTenSigns().size(); i++) {
                if (location.equals(plugin.getTopTenSigns().get(i).getLocation())) {
                    Player p = e.getPlayer();
                    if (p.hasPermission("bskyblocktopten.*") || p.hasPermission("bskyblocktopten.remove")) {
                        if (p.isSneaking()) {
                            plugin.getTopTenSigns().remove(i);
                            plugin.getSignFile().saveData();
                            p.sendMessage(plugin.getMessages().prefix + plugin.getMessages().signRemoved);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage(plugin.getMessages().prefix + plugin.getMessages().pressShiftKey);
                        }
                    } else {
                        e.setCancelled(true);
                        p.sendMessage(plugin.getMessages() + plugin.getMessages().noPermission);
                    }
                    return;
                }
            }
        }
    }
}
