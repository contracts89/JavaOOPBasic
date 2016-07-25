package vehicles.models;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public abstract class Vehicle {
    private double fuel;
    private double fuelCunsumption;
    private double fuelQantity;
    private double tankCapacity;


    public Vehicle(double fuel, double fuelCunsumption, double tankCapacity) {
        this.setFuel(fuel);
        this.setFuelCunsumption(fuelCunsumption);
        this.setTankCapacity(tankCapacity);
        this.setFuelQantity(fuelQantity);
    }



    protected double getFuelQantity() {
        return fuelQantity;
    }

    protected void setFuelQantity(double fuelQantity) {
        if (fuelQantity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQantity = fuelQantity;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected double getFuel() {
        return fuel;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected double getFuelCunsumption() {
        return fuelCunsumption;
    }

    protected void setFuelCunsumption(double fuelCunsumption) {
        this.fuelCunsumption = fuelCunsumption;
    }

    public abstract void drive(double kilometers);
    public abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuel());
    }
}
