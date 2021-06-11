package com.epam.geometry.logic;

import com.epam.geometry.model.Cone;

public class ConeLogic {

    public double calculateVolume(Cone cone) {
        return (double) 1 / 3 * Math.PI * Math.pow(cone.getRadius(), 2) * cone.getHeight();
    }

    public double calculateSurfaceArea(Cone cone) {
        double slantHeight = calculateSlantHeight(cone.getHeight(), cone.getRadius());

        return Math.PI * cone.getRadius() * slantHeight + Math.PI * Math.pow(cone.getRadius(), 2);
    }

    private double calculateSlantHeight(double height, double radius) {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
    }
}
