package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalServer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Main Survival Plugin by " + ChatColor.GOLD + ChatColor.ITALIC + "FEEEH" + ChatColor.GREEN + " enabled!");
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerRespawn(), this);
        getServer().getPluginManager().registerEvents(new GUIOnClick(), this);
        //getServer().getPluginManager().registerEvents(new OnPlayerTouchNether(), this);
        //getCommand("voar").setExecutor(new FlyCommand());
        //getCommand("rtp").setExecutor(new RandomTPCommand());
        getCommand("spawn").setExecutor(new TPSpawn());
        getCommand("warp").setExecutor(new WarpCommand());

        RandomTPUtils rtpUtils = new RandomTPUtils(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Main Survival Plugin by " + ChatColor.GOLD + ChatColor.ITALIC + "FEEEH" + ChatColor.DARK_RED + " disabled!");
    }
}