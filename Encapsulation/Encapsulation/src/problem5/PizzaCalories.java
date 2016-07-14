package problem5;

import problem5.models.Dough;
import problem5.models.Pizza;
import problem5.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class PizzaCalories {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Topping> toppings = new ArrayList<>();
        try {
            //pizza input
            String[] input = sc.readLine().split("\\s+");
            String[] secondLine = {""};
            if(input[0].equalsIgnoreCase("dough")){
                String doughType = input[1];
                String bakingTechnique = input[2];
                int doughWeight = Integer.parseInt(input[3]);
                Dough dough = new Dough(doughType, bakingTechnique, doughWeight);
                secondLine = sc.readLine().split("\\s+");
                System.out.printf("%.2f\n", dough.getCaloriesPerGram());
            }
            if(secondLine[0].equals("END")) {
                return;
            }else if(secondLine[0].equals("Topping")){
                String toppingType = secondLine[1];
                double toppingWeight = Double.valueOf(secondLine[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                System.out.printf("%.2f\n",topping.getToppingCaloriesPerGram());
                return;
            }
            String pizzaName = input[1];
            int numberOfToppings = Integer.parseInt(input[2]);
            if (numberOfToppings < 0 || numberOfToppings > 10) {
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }

            //dough input
            String[] doughInput = sc.readLine().split("\\s+");
            String flourType = doughInput[1];
            String bakingTechnique = doughInput[2];
            int weight = Integer.parseInt(doughInput[3]);
            Dough dough = new Dough(flourType, bakingTechnique, weight);

            //Topping input
            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingsInput = sc.readLine().split("\\s+");
                String toppingType = toppingsInput[1];
                int toppingGrams = Integer.parseInt(toppingsInput[2]);
                Topping topping = new Topping(toppingType, toppingGrams);
                toppings.add(topping);
            }
            Pizza pizza = new Pizza(pizzaName, toppings, dough);
            System.out.printf("%s - %.2f Calories.", pizza.getName(), pizza.getTotalCalories());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
