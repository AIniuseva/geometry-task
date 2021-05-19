package com.epam.geometry.model;

import java.util.Objects;

// TODO: This is a placeholder, name this class according to your task
public class Cone {
    private Point point;
    private double height;
    private double radius;

    public Point getPoint() {
        return point;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cone cone = (Cone) o;
        return Double.compare(cone.height, height) == 0 && Double.compare(cone.radius, radius) == 0 && Objects.equals(point, cone.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, height, radius);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "point=" + point +
                ", height=" + height +
                ", radius=" + radius +
                '}';
    }
}
