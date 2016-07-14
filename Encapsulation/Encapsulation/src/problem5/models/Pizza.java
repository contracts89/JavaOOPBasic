package problem5.models;

import java.util.ArrayList;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class Pizza {
    private String name;
    ArrayList<Topping> toppings;
    private Dough dough;

    public Pizza(String name, ArrayList<Topping> toppings, Dough dough) {
        this.setName(name);
        this.toppings = toppings;
        this.setDough(dough);
    }

    public int getNumberOfTopings(){
        return this.getToppings().size();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    private Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public double getTotalCalories(){
        double toppingCalories = 0L;
        for (Topping topping : toppings) {
            toppingCalories += topping.getToppingCaloriesPerGram();
        }
        double doughCalories = this.getDough().getCaloriesPerGram();
        return toppingCalories + doughCalories;
    }
}
