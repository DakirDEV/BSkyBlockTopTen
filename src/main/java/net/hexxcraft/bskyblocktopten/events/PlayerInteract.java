package net.hexxcraft.bskyblocktopten.events;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import net.hexxcraft.bskyblocktopten.utils.SignAPI;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.level.Level;
import world.bentobox.level.TopTen;
import world.bentobox.level.objects.LevelsData;
import world.bentobox.level.objects.TopTenData;

public class PlayerInteract implements Listener {
    private BSkyBlockTopTen plugin;

    public PlayerInteract(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(plugin.getSignAPI().isSign(e.getClickedBlock())) {
                Sign sign = (Sign) e.getClickedBlock().getState();
                Location location = sign.getLocation();

                for (int i = 0; i < plugin.getTopTenSigns().size(); i++) {
                    if(location.equals(plugin.getTopTenSigns().get(i).getLocation())) {
                        e.getPlayer().performCommand("is top");
                        return;
                    }
                }
            }
        }
    }
}
