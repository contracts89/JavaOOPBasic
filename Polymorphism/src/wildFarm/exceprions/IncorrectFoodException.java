package wildFarm.exceprions;

/**
 * Created by Radoslav on 24.7.2016 г..
 */
public class IncorrectFoodException extends IllegalArgumentException{

    public IncorrectFoodException(String message){
        super(message);
    }
}
