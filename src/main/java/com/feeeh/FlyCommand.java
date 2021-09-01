package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("feeeh.survival.fly")) {
                    fly(player);
                } else {
                    player.sendMessage(Join.playerNotPerms);
                }
            } else if (args.length == 1) {
                if (player.hasPermission("feeeh.survival.othersfly")) {
                    Player targetPlayer = Bukkit.getPlayer(args[0]);
                    if (!(targetPlayer == null)) {
                        fly(targetPlayer);
                        player.sendMessage(Join.serverPrefix + ChatColor.GREEN + "Você fez " + targetPlayer.getDisplayName() + " voar/cair!");
                    } else {
                        player.sendMessage(Join.playerNotOnline);
                    }
                } else {
                    player.sendMessage(Join.serverPrefix + ChatColor.YELLOW + "Mais argumentos do que deveria ou você não pode usar esse comando.");
                }
            } else {
                if (player.hasPermission("feeeh.survival.othersfly")) {
                    player.sendMessage(Join.tooManyArgs);
                } else {
                    player.sendMessage(Join.serverPrefix + ChatColor.YELLOW + "Você não pode usar esse comando com tantos argumentos.");
                }
            }
        } else {
            sender.sendMessage(Join.notaPlayer);
        }
        return true;
    }

    private void fly (Player player) {
        if (listOfFlyingPlayers.contains(player)){
            listOfFlyingPlayers.remove(player);
            player.setAllowFlight(false);
            player.sendMessage(Join.serverPrefix + ChatColor.AQUA + "Você não pode mais voar!");

        } else if (!listOfFlyingPlayers.contains(player)) {
            listOfFlyingPlayers.add(player);
            player.setAllowFlight(true);
            player.sendMessage(Join.serverPrefix + ChatColor.AQUA + "Você pode voar agora!");
        }
    }
}