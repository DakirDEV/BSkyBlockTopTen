package net.hexxcraft.bskyblocktopten.events;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChange implements Listener {
    private BSkyBlockTopTen plugin;

    public SignChange(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[bsbtopten]")) {
            if (!e.getLine(1).equalsIgnoreCase("")) {
                try {
                    Player p = e.getPlayer();
                    if (p.hasPermission("bskyblocktopten.*") || p.hasPermission("bskyblocktopten.create")) {
                        int place = Integer.parseInt(e.getLine(1));
                        String placeString = String.valueOf(place);
                        String nameString = plugin.getTopTenAPI().getPlayerName(place);
                        String levelString = plugin.getTopTenAPI().getLevel(place).toString();
                        e.setLine(0, plugin.getMessages().signLine1.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
                        e.setLine(1, plugin.getMessages().signLine2.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
                        e.setLine(2, plugin.getMessages().signLine3.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
                        e.setLine(3, plugin.getMessages().signLine4.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));

                        if (plugin.getSignAPI().isWallSign(e.getBlock())) {
                            plugin.getSkullAPI().updateSkull(e.getBlock(), plugin.getTopTenAPI().getPlayerUUID(place));
                        }

                        Location loc = e.getBlock().getLocation();
                        TopTenSign sign = new TopTenSign(place, loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
                        plugin.getTopTenSigns().add(sign);

                        plugin.getSignFile().saveData();

                        p.sendMessage(plugin.getMessages().prefix + plugin.getMessages().signCreated);
                    }
                } catch (NumberFormatException ex) {
                }
            }
        }
    }
}
