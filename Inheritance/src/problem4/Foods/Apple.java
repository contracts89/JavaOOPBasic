package problem4.Foods;

import problem4.contracts.Food;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class Apple implements Food{
    private static final int POINTS_OF_HAPPYNESS = 1;

    @Override
    public int getPointsOfHappyness() {
        return POINTS_OF_HAPPYNESS;
    }
}
