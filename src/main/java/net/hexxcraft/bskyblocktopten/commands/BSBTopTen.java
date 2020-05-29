package net.hexxcraft.bskyblocktopten.commands;

import net.hexxcraft.bskyblocktopten.BSkyBlockTopTen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BSBTopTen implements CommandExecutor {
    private BSkyBlockTopTen plugin;

    public BSBTopTen(BSkyBlockTopTen plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("bskyblocktopten.*") || sender.hasPermission("bskyblocktopten.reload")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                plugin.getConfigFile().load();
                plugin.getMessagesFile().load();
                plugin.getSignFile().loadData();

                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    p.sendMessage(plugin.getMessages().prefix + plugin.getMessages().reload);
                } else {
                    plugin.getLogger().info(plugin.getMessages().reload);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

}
