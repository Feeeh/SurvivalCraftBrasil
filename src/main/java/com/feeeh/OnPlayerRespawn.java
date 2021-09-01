package com.feeeh;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerRespawn implements Listener {

    @EventHandler
    public void onPlayerRespawn (PlayerRespawnEvent e) {
        if (!e.isBedSpawn()) {
            e.setRespawnLocation(Join.spawnLoc);
        }
    }
}