package vehicles.models;

import java.text.DecimalFormat;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Truck extends Vehicle {
    private static final double INCRESED_FUEL_CONSUMPTION = 1.6;
    private static final double REFUEL_PERSENTAGE = 0.95;

    public Truck(double fuel, double fuelCunsumption, double tankCapacity) {
        super(fuel, (fuelCunsumption + INCRESED_FUEL_CONSUMPTION), tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        double kmCarCanDrive = this.getFuel() / this.getFuelCunsumption();
        if(kmCarCanDrive >= kilometers){
            System.out.println("Truck travelled " + new DecimalFormat("0.###").format(kilometers) + " km");
            double consumptedFuel = kilometers * getFuelCunsumption();
            super.setFuel(super.getFuel() - consumptedFuel);
        }else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        super.setFuel(super.getFuel() + (liters * REFUEL_PERSENTAGE));
    }
}
