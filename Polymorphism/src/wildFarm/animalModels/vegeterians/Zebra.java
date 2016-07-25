package wildFarm.animalModels.vegeterians;

import wildFarm.animalModels.Mamal;
import wildFarm.exceprions.IncorrectFoodException;
import wildFarm.foodModels.Food;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Zebra extends Mamal {

    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(this.isFoodMeat(food)){
            throw new IncorrectFoodException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");;
    }
}
