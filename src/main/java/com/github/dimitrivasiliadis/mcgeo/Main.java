package com.github.dimitrivasiliadis.mcgeo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.World;
import com.github.dimitrivasiliadis.mcgeo.module.lidar.LiDARReader;

import java.io.IOException;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        World world = Bukkit.getWorld("world"); // Assuming default world

        try {
            LiDARReader lidarReader = new LiDARReader("data/copc.laz");
            double[][] elevationData = lidarReader.extractElevationData();

            com.github.dimitrivasiliadis.mcgeo.MinecraftTerrainGenerator terrainGenerator = new com.github.dimitrivasiliadis.mcgeo.MinecraftTerrainGenerator(world);
            terrainGenerator.generateTerrain(elevationData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}