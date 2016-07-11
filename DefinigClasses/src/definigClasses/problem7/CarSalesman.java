package definigClasses.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Radoslav on 30.6.2016 г..
 */
class Car {
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String wght = "";
        String dsplmnt = "";
        if (this.weight == 0) {
            wght = "n/a";
            if (this.engine.engineDisplacement == 0) {
                dsplmnt = "n/a";
                return String.format("%s:%n  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s%n  Weight: %s%n  Color: %s", this.model, this.engine.engineModel, this.engine.enginePower, dsplmnt, this.engine.engineEfficiency, wght, this.color);
            } else {
                return String.format("%s:%n  %s:%n    Power: %d%n    Displacement: %d%n    Efficiency: %s%n  Weight: %s%n  Color: %s", this.model, this.engine.engineModel, this.engine.enginePower, this.engine.engineDisplacement, this.engine.engineEfficiency, wght, this.color);
            }
        } else {
            if (this.engine.engineDisplacement == 0) {
                dsplmnt = "n/a";
                return String.format("%s:%n  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s%n  Weight: %d%n  Color: %s", this.model, this.engine.engineModel, this.engine.enginePower, dsplmnt, this.engine.engineEfficiency, this.weight, this.color);
            } else {
                return String.format("%s:%n  %s:%n    Power: %d%n    Displacement: %d%n    Efficiency: %s%n  Weight: %d%n  Color: %s", this.model, this.engine.engineModel, this.engine.enginePower, this.engine.engineDisplacement, this.engine.engineEfficiency, this.weight, this.color);
            }
        }
    }
}

class Engine {
    String engineModel;
    int enginePower;
    int engineDisplacement;
    String engineEfficiency;

    public Engine(String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public Engine(String engineModel, int enginePower) {

        this(engineModel, enginePower, 0, "n/a");
    }

    public Engine(String engineModel, int enginePower, int engineDisplacement) {

        this(engineModel, enginePower, engineDisplacement, "n/a");
    }

    public Engine(String engineModel, int enginePower, String engineEfficiency) {

        this(engineModel, enginePower, 0, engineEfficiency);
    }
}

public class CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        ArrayList<Engine> engines = new ArrayList<>();
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Engine engine;
            String[] tokens = sc.readLine().split("\\s+");
            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);
            if (tokens.length == 4) {
                int engineDisplacement = Integer.parseInt(tokens[2]);
                String engineEfficiency = tokens[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            } else if (tokens.length == 3) {
                if (isNum(tokens[2])) {
                    int engineDisplacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                } else {
                    String engineEfficiency = tokens[2];
                    engine = new Engine(engineModel, enginePower, engineEfficiency);
                }
            } else {
                engine = new Engine(engineModel, enginePower);
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(sc.readLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.readLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine engine = null;
            int weight = 0;
            String color = "";
            Car car;
            for (Engine engine1 : engines) {
                if (engine1.engineModel.equals(engineModel)) {
                    engine = engine1;
                }
            }
            if (tokens.length == 4) {
                weight = Integer.parseInt(tokens[2]);
                color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 3) {
                if (isNum(tokens[2])) {
                    weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    color = tokens[2];
                    car = new Car(model, engine, color);
                }
            } else {
                car = new Car(model, engine);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static boolean isNum(String token) {
        boolean isNum = true;
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException ex) {
            isNum = false;
        }
        return isNum;
    }
}
