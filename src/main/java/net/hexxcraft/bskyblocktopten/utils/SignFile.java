package net.hexxcraft.bskyblocktopten.utils;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import net.hexxcraft.bskyblocktopten.objects.TopTenSign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SignFile {
    private BSkyBlockTopTen plugin;

    public SignFile(BSkyBlockTopTen plugin) {
        this.plugin = plugin;

        if (!getFile().exists()) {
            try {
                getFile().createNewFile();

                FileConfiguration cfg = getFileConfiguration();
                cfg.set("signs", new ArrayList<String>());
                try {
                    cfg.save(getFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveData() {
        FileConfiguration cfg = getFileConfiguration();

        List<String> signStrings = new ArrayList<String>();

        for (int i = 0; i < plugin.getTopTenSigns().size(); i++) {
            signStrings.add(plugin.getTopTenSigns().get(i).toString());
        }

        cfg.set("signs", signStrings);

        try {
            cfg.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        return new File(plugin.getDataFolder(), "signs.yml");
    }

    private FileConfiguration getFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void loadData() {
        FileConfiguration cfg = getFileConfiguration();

        List<String> signStrings = (List<String>) cfg.getList("signs");

        for (int i = 0; i < signStrings.size(); i++) {
            plugin.getTopTenSigns().add(TopTenSign.valueOf(signStrings.get(i)));
        }
    }
}
