package problem4.factories;

import problem4.Foods.*;
import problem4.contracts.Food;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class FoodFactory {

    public Food getFood(String foodType){

        if(foodType.equalsIgnoreCase("apple")){
            return new Apple();
        } else if (foodType.equalsIgnoreCase("melon")) {
            return new Melon();
        }else if(foodType.equalsIgnoreCase("cram")){
            return new Cram();
        }else if(foodType.equalsIgnoreCase("honeycake")){
            return new HoneyCake();
        }else if(foodType.equalsIgnoreCase("lembas")){
            return new Lembas();
        }else if(foodType.equalsIgnoreCase("mushrooms")){
            return new Mushrooms();
        }else {
            return new EverythingElse();
        }
    }
}
