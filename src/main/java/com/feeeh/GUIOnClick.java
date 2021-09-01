package com.feeeh;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIOnClick implements Listener {

    @EventHandler
    public void clickEvent (InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Portais Para Outros Mundos")) {
            switch (e.getCurrentItem().getType()) {
                case NETHER_STAR:
                    player.closeInventory();
                    player.teleport(Join.spawnLoc);
                    break;

                case GRASS:
                    player.closeInventory();
                    player.teleport(Join.resourcesLoc);
                    break;

                case NETHERRACK:
                    player.closeInventory();
                    player.teleport(Join.netherLoc);
                    break;

                case ENDER_STONE:
                    player.closeInventory();
                    player.teleport(Join.theEndLoc);
                    break;

                case DIAMOND_SWORD:
                    player.closeInventory();
                    player.teleport(Join.arenaPvPLoc);
                    break;

                case BOOK:
                    player.closeInventory();
                    player.teleport(Join.tutorialLoc);
                    break;
            }
            e.setCancelled(true);
        }
    }
}
