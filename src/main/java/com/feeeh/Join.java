package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    public static String serverPrefix = ChatColor.GOLD + "" + ChatColor.BOLD + "[SERVIDOR] ";
    public static String notaPlayer = serverPrefix + ChatColor.DARK_RED + "Você precisa ser um jogador para usar esse comando.";
    public static String playerNotOnline = serverPrefix + ChatColor.YELLOW + "Esse jogador não está online.";
    public static String tooManyArgs = serverPrefix + ChatColor.DARK_RED + "Mais argumentos do que deveria.";
    public static String playerNotPerms = serverPrefix + ChatColor.YELLOW + "Você não pode usar esse comando.";

    public static Location spawnLoc = new Location(Bukkit.getWorld("halkitos"), -51.5, 71, 187.5, 180 ,0);
    public static Location resourcesLoc = new Location(Bukkit.getWorld("Recursos"), 84.5, 63, -355.5, -90, 0);
    public static Location netherLoc = new Location(Bukkit.getWorld("halkitos_nether"), 186, 86, 325);
    public static Location theEndLoc = new Location(Bukkit.getWorld("halkitos_the_end"), -0.5, 66, 3.5, 180, 0);
    public static Location arenaPvPLoc = new Location(Bukkit.getWorld("halkitos"), -30, 69, 208, -60, 0);
    public static Location tutorialLoc = new Location(Bukkit.getWorld("halkitos"), -51.5, 54, 187, 180, 0);

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage("");
        if (!player.hasPlayedBefore()) {
            player.teleport(spawnLoc);
            player.sendMessage(serverPrefix + ChatColor.GREEN + "Bem-vindo/a ao servidor, " + player.getName() + "!");
        } else {
            player.sendMessage(serverPrefix + ChatColor.GREEN + "Bem-vindo/a de volta ao servidor, " + player.getName() + "!");
        }
    }
}