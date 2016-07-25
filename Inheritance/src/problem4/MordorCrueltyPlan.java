package problem4;

import problem4.contracts.Food;
import problem4.factories.FoodFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class MordorCrueltyPlan {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split("(\\s+)");
        Gandalf gandalf = new Gandalf();
        for (int i = 0; i < line.length; i++) {
            FoodFactory foodFactory = new FoodFactory();
            gandalf.addFood(foodFactory.getFood(line[i].trim()));
        }
        gandalf.calcMoodScore();
        gandalf.setGandalfMood();
        System.out.println(gandalf.toString());
    }
}
