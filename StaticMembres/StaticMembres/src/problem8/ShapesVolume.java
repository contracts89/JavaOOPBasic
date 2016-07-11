package problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 10.7.2016 г..
 */

class Cube{
    private double side;

    public Cube(double side) {
        this.setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

class Cylinder{
    private double radius;
    private double hegth;

    public Cylinder(double radius, double hegth) {
        this.setRadius(radius);
        this.setHegth(hegth);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHegth() {
        return hegth;
    }

    public void setHegth(double hegth) {
        this.hegth = hegth;
    }
}

class TrianglePrism{
    private double baseSide;
    private double heigth;
    private double length;

    public TrianglePrism(double baseSide, double heigth, double length) {
        this.setBaseSide(baseSide);
        this.setHeigth(heigth);
        this.setLength(length);
    }

    public double getBaseSide() {
        return baseSide;
    }

    public void setBaseSide(double baseSide) {
        this.baseSide = baseSide;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}

class VolumeCalculator{
    public static void calcCubeVolume(Cube cube){
        System.out.printf("%.3f", Math.pow(cube.getSide(), 3));
    }

    public static void calcCylinderVolume(Cylinder cylinder){
        double doubleRadius = Math.pow(cylinder.getRadius(), 2);
        double result = 3.14159265359 * doubleRadius * cylinder.getHegth();
        System.out.printf("%.3f", result);
    }

    public static void calcTrianglePrismVolume(TrianglePrism trianglePrism){
        double v = ((trianglePrism.getBaseSide() * trianglePrism.getHeigth()) / 2) * trianglePrism.getLength();
        System.out.printf("%.3f", v);
    }
}
public class ShapesVolume {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] tokens = sc.readLine().split("\\s+");
            if(tokens[0].equals("End")){
                break;
            }
            switch (tokens[0]){
                case "Cube":
                    double sideLength = Double.parseDouble(tokens[1]);
                    Cube cube = new Cube(sideLength);
                    VolumeCalculator.calcCubeVolume(cube);
                    break;
                case "Cylinder":
                    double radius = Double.parseDouble(tokens[1]);
                    double height = Double.parseDouble(tokens[2]);
                    Cylinder cylinder = new Cylinder(radius, height);
                    VolumeCalculator.calcCylinderVolume(cylinder);
                    break;
                case "TrianglePrism":
                    double baseSide = Double.parseDouble(tokens[1]);
                    double hightFromBaseSide = Double.parseDouble(tokens[2]);
                    double length = Double.parseDouble(tokens[3]);
                    TrianglePrism trianglePrism = new TrianglePrism(baseSide, hightFromBaseSide, length);
                    VolumeCalculator.calcTrianglePrismVolume(trianglePrism);
                    break;
            }
            System.out.println();
        }
    }
}
