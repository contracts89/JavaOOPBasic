package wildFarm.animalModels.animalFactory;

import wildFarm.animalModels.Animal;
import wildFarm.animalModels.predators.Cat;
import wildFarm.animalModels.predators.Tiger;
import wildFarm.animalModels.vegeterians.Mouse;
import wildFarm.animalModels.vegeterians.Zebra;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class AnimalFactory {

    public Animal createAnimal(String anymalType,
                               String animalName,
                               double animalWeight,
                               String animalLivingRegion){

        Animal animal = null;

        switch (anymalType.toLowerCase()){
            case "mouse":
                animal = new Mouse(animalName, animalWeight, animalLivingRegion);
                break;
            case "zebra":
                animal = new Zebra(animalName, animalWeight, animalLivingRegion);
                break;
            case "tiger":
                animal = new Tiger(animalName, animalWeight, animalLivingRegion);
            break;
        }
        return animal;
    }

    public Animal createAnimal(String animalType,
                             String animalName,
                             double animalWeight,
                             String animalLivingRegion,
                             String catBreed){


        return new Cat(animalName, animalWeight, animalLivingRegion, catBreed);
    }
}
