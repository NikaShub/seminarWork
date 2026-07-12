package FinalPrep_Poly;

import java.util.ArrayList;
import java.util.List;

interface Shape3D {
    double getVolume();
    String getName();
}

class Sphere implements Shape3D {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String getName() {
        return "Sphere";
    }
}

class Cube implements Shape3D {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public String getName() {
        return "Cube";
    }
}

class Cylinder implements Shape3D {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String getName() {
        return "Cylinder";
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        List<Shape3D> shapes = new ArrayList<>();

        shapes.add(new Sphere(5));
        shapes.add(new Cube(3));
        shapes.add(new Cylinder(2, 10));
        for (Shape3D shape : shapes) {
            System.out.println("Shape: " + shape.getName() + ", Volume: " + shape.getVolume());
        }
    }
}