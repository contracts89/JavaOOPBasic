package problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 6.7.2016 г..
 */
class Car{
    private int speed;
    private double fuel;
    private int fuelEconomy;
    private double travelledDistance;
    private double timeTravelled;

    public Car(int speed, double fuel, int fuelEconomy) {
        this.setSpeed(speed);
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.setTravelledDistance(travelledDistance);
        this.setTimeTravelled(timeTravelled);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(int fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public double getTimeTravelled() {
        return timeTravelled;
    }

    public void setTimeTravelled(double timeTravelled) {
        this.timeTravelled = timeTravelled;
    }

    public void carTravel(int kilometers){
        double travelledKilometers = 0L;
        double timeTravelled = 0L;
        double speed = this.getSpeed();
        double carFuel = this.getFuel();
        double economy = this.getFuelEconomy();
        double literPerKm = economy / 100;
        double fuelNeededToTravel = kilometers * literPerKm;
        if(fuelNeededToTravel <= carFuel){
            carFuel -= fuelNeededToTravel;
            this.setFuel(carFuel);
            travelledKilometers += kilometers;
            this.setTravelledDistance(travelledKilometers);
            timeTravelled = (int) travelledKilometers / speed;
            this.setTimeTravelled(timeTravelled);
        }else {
            travelledKilometers = carFuel / literPerKm;
            carFuel = 0;
            this.setFuel(carFuel);
            timeTravelled = (int) travelledKilometers / speed * 60;
            this.setTravelledDistance(travelledKilometers);
            this.setTimeTravelled(timeTravelled);
        }
    }

    public void printTimeTravelled(){
        double timeTravelled = getTimeTravelled();
        double hours = timeTravelled % 60;
        double minutes = timeTravelled / 60;
        System.out.printf("Total time: %.0f hours and %.0f minutes%n", hours, minutes);
    }

    //int getHours(){
    //    int raw = (int) this.getRawTravelTime();
    //    int hours = raw / 60;
    //    return hours;
    //}
    //int getMinutes(){
    //    int raw = (int) this.getRawTravelTime();
    //    int minutes = raw % 60;
    //    return minutes;
    //}
    //private double getRawTravelTime() {
    //    double hoursAndMinutes = (this.getTravelledDistance() / this.getSpeed()) * 60;
    //    return hoursAndMinutes;
    //}

    public void refuelCar(double liters){
        this.setFuel(this.getFuel() + liters);
    }
}

public class CarProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] carTokens = sc.readLine().split("\\s+");
        int carSpeed = Integer.parseInt(carTokens[0]);
        double carFuel = Double.parseDouble(carTokens[1]);
        int fuelEconomy = Integer.parseInt(carTokens[2]);
        Car car = new Car(carSpeed, carFuel, fuelEconomy);
        while(true){
            String[] input = sc.readLine().split("\\s+");
            if(input[0].equals("END")){
                break;
            }

            switch (input[0]){
                case "Travel":
                    int kilometers = Integer.parseInt(input[1]);
                    car.carTravel(kilometers);
                    break;
                case "Distance":
                    System.out.printf("Total distance: %.1f kilometers%n", car.getTravelledDistance());
                    break;
                case "Time":
                    car.printTimeTravelled();
                    break;
                case "Fuel":
                    System.out.printf("Fuel left: %.1f liters%n", car.getFuel());
                    break;
                case "Refuel":
                    double liters = Integer.parseInt(input[1]);
                    car.refuelCar(liters);
                    break;
            }
        }
    }
}
