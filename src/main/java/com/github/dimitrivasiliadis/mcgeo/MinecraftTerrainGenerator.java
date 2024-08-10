package com.github.dimitrivasiliadis.mcgeo;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import java.util.Random;

public class MinecraftTerrainGenerator {
    private World world;

    public MinecraftTerrainGenerator(World world) {
        this.world = world;
    }

    public void generateTerrain(double[][] elevationData) {
        for (double[] point : elevationData) {
            int x = (int) point[0];
            int z = (int) point[1];
            int y = (int) Math.min(point[2], world.getMaxHeight() - 1); // Ensure y is within world height

            // Set the block at the specified coordinates
            Location loc = new Location(world, x, y, z);
            world.getBlockAt(loc).setType(Material.STONE);
        }
    }
}
