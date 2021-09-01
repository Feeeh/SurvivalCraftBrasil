package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                Location newLoc = RandomTPUtils.generateLocation(player);
                player.teleport(newLoc);
                player.sendMessage(Join.serverPrefix + ChatColor.BLUE + "Sua nova coordenada é: " +
                        ChatColor.GREEN + "\nX: " + newLoc.getBlockX() + "\nY: " + newLoc.getBlockY() + "\nZ: " + newLoc.getBlockZ());
            } else if (args.length == 1) {
                if (player.hasPermission("feeeh.survival.rtpothers")) {
                    Player targetPlayer = Bukkit.getPlayer(args[0]);
                    if (!(targetPlayer == null)) {
                        Location newLoc = RandomTPUtils.generateLocation(targetPlayer);
                        targetPlayer.teleport(newLoc);
                        targetPlayer.sendMessage(Join.serverPrefix + ChatColor.BLUE + "Sua nova coordenada é: " +
                                ChatColor.GREEN + "\nX: " + newLoc.getBlockX() + "\nY: " + newLoc.getBlockY() + "\nZ: " + newLoc.getBlockZ());
                        player.sendMessage(Join.serverPrefix + ChatColor.GREEN + "Você teleportou randomicamente " + targetPlayer.getDisplayName() + ".");
                    } else {
                        player.sendMessage(Join.playerNotOnline);
                    }
                } else {
                    player.sendMessage(Join.playerNotPerms);
                }
            }
        } else {
            sender.sendMessage(Join.notaPlayer);
        }

        return true;
    }
}
