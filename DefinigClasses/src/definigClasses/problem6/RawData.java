package definigClasses.problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by Radoslav on 30.6.2016 г..
 */
class Car {
    String model;
    CarEngine carEngine;
    ArrayList<Tire> carTire;
    Cargo carCargo;

    public Car(String model, CarEngine carEngine, ArrayList<Tire> carTire, Cargo carCargo) {
        this.model = model;
        this.carEngine = carEngine;
        this.carTire = carTire;
        this.carCargo = carCargo;
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}

class Tire {
    double tirePressure;
    int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }
}

class CarEngine {
    int engineSpeed;
    int enginePower;

    public CarEngine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
}

class Cargo {
    int cargoWeight;
    String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}

public class RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Car> cars = new LinkedList<>();
        LinkedHashSet<Car> resultCarList = new LinkedHashSet<>();
        int n=Integer.parseInt(sc.readLine());
        for (int i = 0; i < n; i++) {
            String[]tokens = sc.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeigth = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            ArrayList<Tire> tires = new ArrayList<>();
            CarEngine carEngine = new CarEngine(engineSpeed, enginePower);
            Cargo carCargo = new Cargo(cargoWeigth, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            tires.add(tire1);tires.add(tire2);tires.add(tire3);tires.add(tire4);
            Car car = new Car(model, carEngine, tires, carCargo);
            cars.add(car);
        }
        String line = sc.readLine();
        switch (line){
            case "fragile":
                for (Car car : cars) {
                    for (Tire tire : car.carTire) {
                        if(car.carCargo.cargoType.equals("fragile") && tire.tirePressure < 1){
                            resultCarList.add(car);
                        }
                    }

                }
                break;
            case "flamable":
                for (Car car : cars) {
                    if(car.carCargo.cargoType.equals("flamable") && car.carEngine.enginePower > 250){
                        resultCarList.add(car);
                    }
                }
                break;
        }
        for (Car car : resultCarList) {
            System.out.println(car);
        }

    }
}

