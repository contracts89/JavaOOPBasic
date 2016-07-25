package vehicles.models;

import java.text.DecimalFormat;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Car extends Vehicle {
    private static final double INCRESED_FUEL_CONSUMPTION = 0.9;

    public Car(double fuel, double fuelCunsumption, double tankCapacity) {
        super(fuel, fuelCunsumption, tankCapacity);
    }


    @Override
    public void drive(double kilometers) {
        double kmCarCanDrive = this.getFuel() / this.getFuelCunsumption();
        if(kmCarCanDrive >= kilometers){
            System.out.println("Car travelled " + new DecimalFormat("0.###").format(kilometers) + " km");
            double consumptedFuel = kilometers * getFuelCunsumption();
            super.setFuel(super.getFuel() - consumptedFuel);
        }else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if(super.getTankCapacity() < liters){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuel(super.getFuel() + liters);
    }
}
