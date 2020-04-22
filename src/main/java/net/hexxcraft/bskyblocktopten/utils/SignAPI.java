package net.hexxcraft.bskyblocktopten.utils;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;

import java.util.ArrayList;
import java.util.List;

public class SignAPI {
    private BSkyBlockTopTen plugin;

    private List<Material> signTypes = new ArrayList<Material>();
    private List<Material> wallSignTypes = new ArrayList<Material>();

    public SignAPI(BSkyBlockTopTen plugin) {
        this.plugin = plugin;

        signTypes.add(Material.OAK_SIGN);
        signTypes.add(Material.OAK_WALL_SIGN);
        signTypes.add(Material.SPRUCE_SIGN);
        signTypes.add(Material.SPRUCE_WALL_SIGN);
        signTypes.add(Material.BIRCH_SIGN);
        signTypes.add(Material.BIRCH_WALL_SIGN);
        signTypes.add(Material.JUNGLE_SIGN);
        signTypes.add(Material.JUNGLE_WALL_SIGN);
        signTypes.add(Material.ACACIA_SIGN);
        signTypes.add(Material.ACACIA_WALL_SIGN);
        signTypes.add(Material.DARK_OAK_SIGN);
        signTypes.add(Material.DARK_OAK_WALL_SIGN);

        wallSignTypes.add(Material.OAK_WALL_SIGN);
        wallSignTypes.add(Material.SPRUCE_WALL_SIGN);
        wallSignTypes.add(Material.BIRCH_WALL_SIGN);
        wallSignTypes.add(Material.JUNGLE_WALL_SIGN);
        wallSignTypes.add(Material.ACACIA_WALL_SIGN);
        wallSignTypes.add(Material.DARK_OAK_WALL_SIGN);
    }

    public boolean isWallSign(Block block) {
        if (wallSignTypes.contains(block.getState().getType())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSign(Block block) {
        if (signTypes.contains(block.getType())) {
            return true;
        } else {
            return false;
        }
    }

    public void updateSigns() {
        for (TopTenSign topTenSign : plugin.getTopTenSigns()) {
            Location location = topTenSign.getLocation();
            Sign sign = (Sign) location.getBlock().getState();
            int place = topTenSign.getPlace();
            String placeString = String.valueOf(place);
            String nameString = plugin.getTopTenAPI().getPlayerName(place);
            String levelString = plugin.getTopTenAPI().getLevel(place).toString();
            sign.setLine(0, plugin.getMessages().signLine1.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
            sign.setLine(1, plugin.getMessages().signLine2.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
            sign.setLine(2, plugin.getMessages().signLine3.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
            sign.setLine(3, plugin.getMessages().signLine4.replace("%place%", placeString).replace("%name%", nameString).replace("%level%", levelString));
            sign.update();
            if (isWallSign(sign.getBlock())) {
                plugin.getSkullAPI().updateSkull(sign.getBlock(), plugin.getTopTenAPI().getPlayerUUID(place));
            }
        }
    }
}
