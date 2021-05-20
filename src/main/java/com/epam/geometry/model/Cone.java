package com.epam.geometry.model;

import java.util.Objects;

public class Cone {
    private final Point center;
    private final double height;
    private final double radius;

    public Cone(Point center, double height, double radius) {
        this.center = center;
        this.height = height;
        this.radius = radius;
    }

    public Point getPoint() {
        return center;
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
        return Double.compare(cone.height, height) == 0 && Double.compare(cone.radius, radius) == 0 && Objects.equals(center, cone.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, height, radius);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "point=" + center +
                ", height=" + height +
                ", radius=" + radius +
                '}';
    }
}
