package definigClasses.problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Radoslav on 2.7.2016 г..
 */
class Person {
    String name;
    ArrayList<Parent> parents;
    ArrayList<Child> children;
    ArrayList<Pokemon> pokemons;
    HashMap<String, Car> cars;
    HashMap<String, Company> companies;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.cars = new HashMap<>();
        this.companies = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder poks = new StringBuilder();
        for (Pokemon pokemon : this.pokemons) {
            poks.append(pokemon.toString() + "\n");
        }
        StringBuilder pars = new StringBuilder();
        for (Parent parent : this.parents) {
            pars.append(parent.toString() + "\n");
        }
        StringBuilder chlds = new StringBuilder();
        for (Child child : this.children) {
            chlds.append(child.toString() + "\n");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "\n");
        sb.append("Company:\n");
        if (!this.companies.isEmpty()) {
            for (Company company : this.companies.values()) {
                sb.append(company.toString() + "\n");
            }
        }
        sb.append("Car:\n");
        if (!this.cars.isEmpty()) {
            for (Car car : this.cars.values()) {
                sb.append(car.toString() + "\n");
            }
        }
        sb.append("Pokemon:\n");
        if (!this.pokemons.isEmpty()) {
            sb.append(poks);
        }
        sb.append("Parents:\n");
        if (!this.parents.isEmpty()) {
            sb.append(pars);
        }
        sb.append("Children:\n");
        if (!this.children.isEmpty()) {
            sb.append(chlds);
        }
        return sb.toString();
    }
}

class Company {
    String companyName;
    String department;
    double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.department, this.salary);
    }
}

class Pokemon {
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.pokemonName, this.pokemonType);
    }
}

class Parent {
    String parentName;
    String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.parentName, this.parentBirthday);
    }
}

class Child {
    String childName;
    String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.childName, this.childBirthday);
    }
}

class Car {
    String carModel;
    int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.carModel, this.carSpeed);
    }
}

public class Google {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> persons = new HashMap<>();
        while (true) {
            String[] tokens = sc.readLine().split("\\s+");
            if (tokens[0].equals("End")) {
                break;
            }
            String personName = tokens[0];
            Person person = new Person(personName);
            if (!persons.containsKey(personName)){
                persons.put(personName, person);
            }
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String companyDepartment = tokens[3];
                    Double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, companyDepartment, salary);
                    persons.get(personName).companies.put(companyName, company);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    persons.get(personName).cars.put(carModel, car);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    persons.get(personName).pokemons.add(pokemon);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBd = tokens[3];
                    Child child = new Child(childName, childBd);
                    persons.get(personName).children.add(child);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBd = tokens[3];
                    Parent parent = new Parent(parentName, parentBd);
                    persons.get(personName).parents.add(parent);
                    break;
            }
        }

        String line = sc.readLine();
        for (Person person : persons.values()) {
            if (person.name.equals(line)) {
                System.out.println(person);
            }
        }
    }
}
