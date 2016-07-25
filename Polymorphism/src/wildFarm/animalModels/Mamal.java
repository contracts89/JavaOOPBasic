package wildFarm.animalModels;

import wildFarm.animalModels.Animal;
import wildFarm.foodModels.Food;

import java.text.DecimalFormat;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public abstract class Mamal extends Animal {
    public static final DecimalFormat FORMAT;
    private String livingRegion;

    static{
        FORMAT = new DecimalFormat("0.#############");
    }

    public Mamal(String animalName, double animalWeight, String livingRegion) {
        super(animalName,animalWeight);
        this.setLivingRegion(livingRegion);
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    protected boolean isFoodMeat(Food food){
        if(food.getClass().getSimpleName().equalsIgnoreCase("meat")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                FORMAT.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
