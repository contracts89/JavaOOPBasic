package wildFarm.animalModels.vegeterians;

import wildFarm.animalModels.Mamal;
import wildFarm.exceprions.IncorrectFoodException;
import wildFarm.foodModels.Food;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Mouse extends Mamal {

    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(this.isFoodMeat(food)){
            throw new IncorrectFoodException("Mouses are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");;
    }
}
