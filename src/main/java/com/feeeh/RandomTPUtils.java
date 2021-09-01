package com.feeeh;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class RandomTPUtils {

    static SurvivalServer plugin;

    public RandomTPUtils(SurvivalServer plugin) {
        this.plugin = plugin;
    }

    public static HashSet<Material> evilBlocksGrrr = new HashSet<>();

    static {
        evilBlocksGrrr.add(Material.LAVA);
        evilBlocksGrrr.add(Material.FIRE);
        evilBlocksGrrr.add(Material.WATER);
        evilBlocksGrrr.add(Material.STATIONARY_WATER);
    }

    public static Location generateLocation (Player player) {
        Random random = new Random();

        int x = 0;
        int y = 0;
        int z = 0;

        if (plugin.getConfig().getBoolean("world-border")) {
            x = random.nextInt(plugin.getConfig().getInt("border")) * (random.nextBoolean() ? -1 : 1);
            y = 150;
            z = random.nextInt(plugin.getConfig().getInt("border")) * (random.nextBoolean() ? -1 : 1);
        } else if (!plugin.getConfig().getBoolean("world-border")) {
            x = random.nextInt(50000) * (random.nextBoolean() ? -1 : 1);
            y = 150;
            z = random.nextInt(50000) * (random.nextBoolean() ? -1 : 1);
        }

        Location randomLoc = new Location(player.getWorld(), x, y, z);

        y = randomLoc.getWorld().getHighestBlockYAt(randomLoc);
        randomLoc.setY(y);

        while (!isLocationSafe(randomLoc)) {
            randomLoc = generateLocation(player);
        }

        return randomLoc;
    }

    public static boolean isLocationSafe (Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);

        return !(evilBlocksGrrr.contains(below.getType()) || (block.getType().isSolid()) || (above.getType().isSolid()));
    }

}
