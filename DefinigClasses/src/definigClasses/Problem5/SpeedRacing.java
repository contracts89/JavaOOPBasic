package definigClasses.Problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Radoslav on 24.6.2016 г..
 */
class Car {
    String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceCovered;

    public Car(String model, double fuelAmount, double fuelCostPerKm, double distanceCovered) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceCovered = 0D;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, distanceCovered);
    }

    public void carMove(int amountOfKm) {
        double razhod = amountOfKm * this.fuelCostPerKm;
        if (fuelAmount >= razhod) {
            this.distanceCovered += amountOfKm;
            this.fuelAmount -= razhod;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}

public class SpeedRacing {
    public static void main(String[] args) throws IOException {
        Locale locale = new Locale("en");
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.readLine().split("\\s+");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);
            cars.add(new Car(model, fuelAmount, fuelCostPerKm, 0));
        }
        while (true) {
            String[] input = sc.readLine().split("\\s+");
            if (input[0].equals("End")){
                break;
            }
            String carName = input[1];
            int km = Integer.parseInt(input[2]);

            Car[] carsArr = (Car[]) cars.toArray(new Car[cars.size()]);
            for (int i = 0; i < carsArr.length; i++) {
                if(carName.equals(carsArr[i].model)){
                    carsArr[i].carMove(km);
                }
            }
        }

        Iterator iter = cars.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}
