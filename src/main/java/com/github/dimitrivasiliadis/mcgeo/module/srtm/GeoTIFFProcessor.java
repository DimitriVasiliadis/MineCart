package com.github.dimitrivasiliadis.mcgeo.module.srtm;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.util.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffReader;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class GeoTIFFProcessor {

    public int[][] processGeoTIFF(String inputFilePath) throws IOException {
        File geoTiffFile = new File(inputFilePath);
        GeoTiffReader reader = new GeoTiffReader(geoTiffFile, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
        GridCoverage2D coverage = reader.read(null);

        RenderedImage image = coverage.getRenderedImage();
        int width = image.getWidth();
        int height = image.getHeight();

        int[][] elevationData = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int[] pixel = new int[1];
                image.getData().getPixel(x, y, pixel);
                elevationData[x][y] = pixel[0]; // Assuming elevation data is in the first band
            }
        }

        return elevationData;
    }
}