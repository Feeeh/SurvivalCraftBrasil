package com.feeeh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OnPlayerTouchNether implements Listener {

    @EventHandler
    public void onPlayerTouchPortal (PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Material m = p.getLocation().getBlock().getType();
        Location portalLoc = new Location(Bukkit.getWorld("WorldPlot"), -41, 64, 4);

        if (m == Material.PORTAL) {
            p.teleport(portalLoc);
            OpenWarpGui(p);
        }
    }

    public void OpenWarpGui(Player player) {
        GUI.WarpPortal(player);
    }
}
