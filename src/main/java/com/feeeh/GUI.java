package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUI implements Listener {

    public static void WarpPortal (Player player) {
        Player p = player.getPlayer();
        Material m = player.getPlayer().getLocation().getBlock().getType();
        Inventory gui = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Portais Para Outros Mundos");

        ItemStack spawn = new ItemStack (Material.NETHER_STAR);
        ItemStack resources = new ItemStack (Material.GRASS);
        ItemStack nether = new ItemStack (Material.NETHERRACK);
        ItemStack theEnd = new ItemStack (Material.ENDER_STONE);
        ItemStack arenaPvP = new ItemStack (Material.DIAMOND_SWORD);
        ItemStack tutorial = new ItemStack (Material.BOOK);
        ItemStack air = new ItemStack (Material.AIR);

        ItemMeta spawn_meta = resources.getItemMeta();
        spawn_meta.setDisplayName(ChatColor.GOLD + "Spawn");
        ArrayList<String> spawn_lore = new ArrayList<>();
        spawn_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para o spawn.");
        spawn_meta.setLore(spawn_lore);
        spawn.setItemMeta(spawn_meta);

        ItemMeta resources_meta = resources.getItemMeta();
        resources_meta.setDisplayName(ChatColor.GREEN + "Recursos");
        ArrayList<String> resources_lore = new ArrayList<>();
        resources_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para o mundo de exploração.");
        resources_meta.setLore(resources_lore);
        resources.setItemMeta(resources_meta);

        ItemMeta nether_meta = nether.getItemMeta();
        nether_meta.setDisplayName(ChatColor.DARK_RED + "Nether");
        ArrayList<String> nether_lore = new ArrayList<>();
        nether_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para o mundo do Nether.");
        nether_meta.setLore(nether_lore);
        nether.setItemMeta(nether_meta);

        ItemMeta theEnd_meta = theEnd.getItemMeta();
        theEnd_meta.setDisplayName(ChatColor.DARK_PURPLE + "The End");
        ArrayList<String> theEnd_lore = new ArrayList<>();
        theEnd_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para o mundo do The End.");
        theEnd_meta.setLore(theEnd_lore);
        theEnd.setItemMeta(theEnd_meta);

        ItemMeta arenaPvP_meta = arenaPvP.getItemMeta();
        arenaPvP_meta.setDisplayName(ChatColor.AQUA + "Arena PvP");
        ArrayList<String> arenaPvP_lore = new ArrayList<>();
        arenaPvP_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para a Arena PvP.");
        arenaPvP_meta.setLore(arenaPvP_lore);
        arenaPvP.setItemMeta(arenaPvP_meta);

        ItemMeta tutorial_meta = tutorial.getItemMeta();
        tutorial_meta.setDisplayName(ChatColor.YELLOW + "Tutorial");
        ArrayList<String> tutorial_lore = new ArrayList<>();
        tutorial_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Teleporte para o Tutorial.");
        tutorial_meta.setLore(tutorial_lore);
        tutorial.setItemMeta(tutorial_meta);

        ItemStack[] gui_items = {air, air, air, air, spawn, air, air, air, air,
                                air, resources, air, air, nether, air, air, theEnd, air,
                                air, air, arenaPvP, air, air, air, tutorial, air, air};
        gui.setContents(gui_items);

        p.openInventory(gui);

        if (m == Material.PORTAL) {
            p.openInventory(gui);
            Location portalLoc = new Location(Bukkit.getWorld("WorldPlot"), -51.5, 71, 187.5);
            p.teleport(portalLoc);
        }
    }
}
