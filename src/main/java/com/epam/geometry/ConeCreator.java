package com.epam.geometry;

import com.epam.geometry.model.Cone;
import com.epam.geometry.model.Point;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCreator {

    private static final Logger logger = LogManager.getLogger(ConeCreator.class);

    public Cone create(String line) {
        String[] dataForCreation = line.split(" ");

        double x = Double.parseDouble(dataForCreation[0]);
        double y = Double.parseDouble(dataForCreation[1]);
        double z = Double.parseDouble(dataForCreation[2]);
        double height = Double.parseDouble(dataForCreation[3]);
        double radius = Double.parseDouble(dataForCreation[4]);

        Point center = new Point(x, y, z);
        logger.info("Cone is created");
        return new Cone(center, height, radius);
    }
}
