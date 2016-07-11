package problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Animal{
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.setName(name);
        this.setBreed(breed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

class AnimalCLinic{
    private static int patientID = 0;
    private static int healedAnimalsCount = 0;
    private static int rehabilitedAnimalsCount = 0;

    public AnimalCLinic() {
        AnimalCLinic.setPatientID(getPatientID() + 1);
    }

    public static int getPatientID() {
        return patientID;
    }

    public static void setPatientID(int patientID) {
        AnimalCLinic.patientID = patientID;
    }

    public static int getHealedAnimalsCount() {
        return healedAnimalsCount;
    }

    public static void setHealedAnimalsCount(int healedAnimalsCount) {
        AnimalCLinic.healedAnimalsCount = healedAnimalsCount;
    }

    public static int getRehabilitedAnimalsCount() {
        return rehabilitedAnimalsCount;
    }

    public static void setRehabilitedAnimalsCount(int rehabilitedAnimalsCount) {
        AnimalCLinic.rehabilitedAnimalsCount = rehabilitedAnimalsCount;
    }

    public static void heal(){
        AnimalCLinic.setHealedAnimalsCount(getHealedAnimalsCount() + 1);
    }

    public static void rehabilitate(){
        AnimalCLinic.setRehabilitedAnimalsCount(getRehabilitedAnimalsCount() + 1);
    }
}

public class AnimalClinicMain {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Animal> healedAnimals = new ArrayList<>();
        ArrayList<Animal> rehabilitatedAnimals = new ArrayList<>();
        while(true){
            String[] tokens = sc.readLine().split("\\s+");
            if(tokens[0].equals("End")){
                break;
            }
            Animal animal = new Animal(tokens[0], tokens[1]);
            AnimalCLinic animalCLinic = new AnimalCLinic();
            switch (tokens[2]){
                case "heal":
                    AnimalCLinic.heal();
                    System.out.printf("Patient %d: [%s (%s)] has been healed!%n",
                            AnimalCLinic.getPatientID(),
                            animal.getName(),
                            animal.getBreed());
                    healedAnimals.add(animal);
                    break;
                case "rehabilitate":
                    AnimalCLinic.rehabilitate();
                    System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n",
                            AnimalCLinic.getPatientID(),
                            animal.getName(),
                            animal.getBreed());
                    rehabilitatedAnimals.add(animal);
                    break;
            }
        }

        System.out.println("Total healed animals: " + AnimalCLinic.getHealedAnimalsCount());
        System.out.println("Total rehabilitated animals: " + AnimalCLinic.getRehabilitedAnimalsCount());
        String line = sc.readLine();
        switch (line){
            case "heal":
                for (Animal healedAnimal : healedAnimals) {
                    System.out.println(healedAnimal.getName() + " " + healedAnimal.getBreed());
                }
                break;
            case "rehabilitate":
                for (Animal rehabilitatedAnimal : rehabilitatedAnimals) {
                    System.out.println(rehabilitatedAnimal.getName() + " " + rehabilitatedAnimal.getBreed());
                }
                break;
        }
    }
}
