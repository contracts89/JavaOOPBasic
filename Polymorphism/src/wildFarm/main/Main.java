package wildFarm.main;

import wildFarm.animalModels.Animal;
import wildFarm.animalModels.animalFactory.AnimalFactory;
import wildFarm.exceprions.IncorrectFoodException;
import wildFarm.foodModels.Food;
import wildFarm.foodModels.Meat;
import wildFarm.foodModels.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] firstLine = sc.readLine().split("\\s+");
            if(firstLine[0].equals("End")){
                break;
            }
            String[] secondLine = sc.readLine().split("\\s+");
            String animalType = firstLine[0];
            String animalName = firstLine[1];
            double animalWieght = Double.parseDouble(firstLine[2]);
            String livingRegion = firstLine[3];

            AnimalFactory animalFactory = new AnimalFactory();
            Animal animal = null;

            if(firstLine.length > 4){
                String catBreed = firstLine[4];
                animal = animalFactory.createAnimal(animalType, animalName, animalWieght, livingRegion, catBreed);
            }else {
                animal = animalFactory.createAnimal(animalType, animalName, animalWieght, livingRegion);
            }

            Food food = null;
            int quantity = Integer.parseInt(secondLine[1]);
            switch (secondLine[0].toLowerCase()){
                case "vegetable":
                    food = new Vegetable(quantity);
                    break;
                case "meat":
                    food = new Meat(quantity);
                    break;
            }

            animal.makeSound();
            try{
                animal.eat(food);
            }catch (IncorrectFoodException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(animal);
        }
    }
}
