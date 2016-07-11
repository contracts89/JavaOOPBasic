package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Radoslav on 9.7.2016 г..
 */

class BeerCounter {
    private static int beersInStock;
    private static int beersDrankCount;

    public static int getBeersInStock() {
        return beersInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }


    public static void BuyBeer(int bottlesCount){
        beersInStock += bottlesCount;
    }

    public static void DrinkBeer(int bottlesCount){
        beersInStock -= bottlesCount;
        beersDrankCount += bottlesCount;
    }
}

public class BeerCounterMain {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = sc.readLine()).equals("End")){
            Integer[] input = Arrays.stream(
                    line.
                            split("\\s+")).
                    map(Integer::parseInt).
                    toArray(Integer[]::new);
            if(input.length == 1){
                break;
            }
            Integer beersToAdd = input[0];
            Integer beersToDrink = input[1];

            BeerCounter.BuyBeer(beersToAdd);
            BeerCounter.DrinkBeer(beersToDrink);
        }

        System.out.println(BeerCounter.getBeersInStock() + " " + BeerCounter.getBeersDrankCount());
    }
}
