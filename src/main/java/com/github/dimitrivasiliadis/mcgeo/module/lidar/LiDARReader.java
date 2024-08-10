package com.github.dimitrivasiliadis.mcgeo.module.lidar;

import io.pdal.Pipeline;
import io.pdal.PipelineFactory;
import io.pdal.PipelineResult;
import io.pdal.PointView;

import java.io.IOException;

public class LiDARReader {
    private String filePath;

    public LiDARReader(String filePath) {
        this.filePath = filePath;
    }

    public double[][] extractElevationData() throws IOException {
        // Create a PDAL pipeline to read the .copc.laz file
        String pipelineJson = "{"
                + "\"pipeline\": ["
                + "  \"" + filePath + "\""
                + "]"
                + "}";

        Pipeline pipeline = PipelineFactory.createPipeline(pipelineJson);
        PipelineResult result = pipeline.execute();

        // Extract the point view
        PointView view = result.getPointViews().get(0);
        double[][] elevationData = new double[(int) view.size()][3]; // Assuming x, y, z coordinates

        for (int i = 0; i < view.size(); i++) {
            elevationData[i][0] = view.getX(i); // x-coordinate
            elevationData[i][1] = view.getY(i); // y-coordinate
            elevationData[i][2] = view.getZ(i); // z-coordinate (elevation)
        }

        return elevationData;
    }
}
