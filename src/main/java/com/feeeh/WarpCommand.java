package com.feeeh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Join.notaPlayer);
        } else {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("feeeh.survival.warp")) {
                    GUI.WarpPortal(player);
                } else {
                    player.sendMessage(Join.playerNotPerms);
                }
            } else {
                player.sendMessage(Join.tooManyArgs);
            }
        }
        return true;
    }
}