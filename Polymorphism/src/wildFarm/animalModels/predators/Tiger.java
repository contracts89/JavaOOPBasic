package wildFarm.animalModels.predators;

import wildFarm.exceprions.IncorrectFoodException;
import wildFarm.foodModels.Food;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Tiger extends Felime {

    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(!this.isFoodMeat(food)){
            throw new IncorrectFoodException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");;
    }
}
