package vehicles.models;

import java.text.DecimalFormat;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Bus extends Vehicle {
    public Bus(double fuel, double fuelCunsumption, double tankCapacity) {
        super(fuel, fuelCunsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        double kmCarCanDrive = this.getFuel() / (this.getFuelCunsumption() + 1.4);
        if(kmCarCanDrive >= kilometers){
            System.out.println("Bus travelled " + new DecimalFormat("0.###").format(kilometers) + " km");
            double consumptedFuel = kilometers * (this.getFuelCunsumption() + 1.4);
            super.setFuel(super.getFuel() - consumptedFuel);
        }else {
            System.out.println("Bus needs refueling");
        }
    }

    public void drive(double kilometers, boolean isFull){
        double kmCarCanDrive = this.getFuel() / this.getFuelCunsumption();
        if(kmCarCanDrive >= kilometers){
            System.out.println("Bus travelled " + new DecimalFormat("0.###").format(kilometers) + " km");
            double consumptedFuel = kilometers * getFuelCunsumption();
            super.setFuel(super.getFuel() - consumptedFuel);
        }else {
            System.out.println("Bus needs refueling");
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
