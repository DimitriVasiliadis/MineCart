package com.github.dimitrivasiliadis.mcgeo.module.srtm;

import java.io.IOException;

public class GeoTIFFToMinecraft {

    public static void main(String[] args) {
        String inputFilePath = "data/monaco.tif";
        String outputWorldPath = "world/";

        try {
            // Process the GeoTIFF file
            GeoTIFFProcessor processor = new GeoTIFFProcessor();
            int[][] elevationData = processor.processGeoTIFF(inputFilePath);

            // Generate Minecraft world based on elevation data
            MinecraftWorldGenerator generator = new MinecraftWorldGenerator();
            generator.generateWorld(elevationData, outputWorldPath);

            System.out.println("Minecraft world generated successfully at: " + outputWorldPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
