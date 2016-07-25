package vehicles;

import vehicles.models.Bus;
import vehicles.models.Car;
import vehicles.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] inputLineOne = sc.readLine().split("\\s+");
        Double carFuel = Double.parseDouble(inputLineOne[1]);
        Double carFuelConsumprion = Double.parseDouble(inputLineOne[2]);
        Double carTankCapacity = Double.parseDouble(inputLineOne[3]);
        Car car = new Car(carFuel, carFuelConsumprion, carTankCapacity);

        String[] inputLineTwo = sc.readLine().split("\\s+");
        Double truckFuel = Double.parseDouble(inputLineTwo[1]);
        Double truckFuelConsumprion = Double.parseDouble(inputLineTwo[2]);
        Double truckTankCapacity = Double.parseDouble(inputLineTwo[3]);
        Truck truck = new Truck(truckFuel,truckFuelConsumprion, truckTankCapacity);

        String[] inputLineThree = sc.readLine().split("\\s+");
        Double busFuel = Double.parseDouble(inputLineThree[1]);
        Double busFuelConsumprion = Double.parseDouble(inputLineThree[2]);
        Double busTankCapacity = Double.parseDouble(inputLineThree[3]);
        Bus bus = new Bus(busFuel,busFuelConsumprion, busTankCapacity);

        int num = Integer.parseInt(sc.readLine());
        for (int i = 0; i < num; i++) {
            String[] command = sc.readLine().split("\\s+");
            double value = Double.parseDouble(command[2]);
            try{
                switch (command[0].toLowerCase()){
                    case "drive":
                        if(command[1].equalsIgnoreCase("car")){
                            car.drive(value);
                        }else if(command[1].equalsIgnoreCase("truck")){
                            truck.drive(value);
                        }else {
                            bus.drive(value);
                        }
                        break;
                    case "driveempty":
                        bus.drive(value, true);
                        break;
                    case "refuel":
                        if(command[1].equalsIgnoreCase("car")){
                            car.refuel(value);
                        }else if(command[1].equalsIgnoreCase("truck")){
                            truck.refuel(value);
                        }else {
                            bus.refuel(value);
                        }
                        break;
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
