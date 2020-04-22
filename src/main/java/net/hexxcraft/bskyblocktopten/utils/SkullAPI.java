package net.hexxcraft.bskyblocktopten.utils;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

import java.util.UUID;

public class SkullAPI {
    private BSkyBlockTopTen plugin;

    public SkullAPI(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    public void updateSkull(Block block, UUID uuid) {
        BlockData data = block.getBlockData();
        if (data instanceof Directional) {
            Directional directional = (Directional) data;

            Block attachedBlock = block.getRelative(directional.getFacing().getOppositeFace()).getRelative(BlockFace.UP);
            OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);

            if (attachedBlock.getType() == Material.PLAYER_HEAD) {
                final Skull skull = (Skull) attachedBlock.getState();
                skull.setOwningPlayer(player);
                skull.update();
                Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    public void run() {
                        skull.update();
                    }
                }, 10L);
            } else if (block.getLocation().add(0,1,0).getBlock().getType() == Material.PLAYER_WALL_HEAD) {
                final Skull skull = (Skull) block.getLocation().add(0,1,0).getBlock().getState();
                skull.setOwningPlayer(player);
                skull.update();
                Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    public void run() {
                        skull.update();
                    }
                }, 10L);
            }
        }
    }
}
