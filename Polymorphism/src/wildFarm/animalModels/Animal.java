package wildFarm.animalModels;

import wildFarm.foodModels.Food;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalName, double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(0);
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void makeSound() {
    }

    public void eat(Food food) {
        this.setFoodEaten(food.getQuatity());
    }
}
