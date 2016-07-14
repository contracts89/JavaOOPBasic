package problem5.models;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class Topping {
    private static final int TOPPING_BASE_CALORIES_PER_GRAM = 2;
    private String toppingType;
    private double toppingWeight;

    public Topping(String toppingType, double toppingWeight) {
        this.setToppingType(toppingType);
        this.setToppingWeight(toppingWeight);
    }

    private String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equalsIgnoreCase("meat") && !toppingType.equalsIgnoreCase("veggies") && !toppingType.equalsIgnoreCase("cheese") && !toppingType.equalsIgnoreCase("sauce")){
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private double getToppingWeight() {
        return toppingWeight;
    }

    private void setToppingWeight(double toppingWeight) {
        if(toppingWeight < 1 || toppingWeight > 50){
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in the range [1..50].");
        }
        this.toppingWeight = toppingWeight;
    }

    public double getToppingCaloriesPerGram(){
        double caloriesPerToppingType = 0L;
        switch (this.getToppingType().toLowerCase()){
            case "meat":
                caloriesPerToppingType = 1.2;
                break;
            case "veggies":
                caloriesPerToppingType = 0.8;
                break;
            case "cheese":
                caloriesPerToppingType = 1.1;
                break;
            case "sauce":
                caloriesPerToppingType = 0.9;
                break;
        }

        return TOPPING_BASE_CALORIES_PER_GRAM * this.getToppingWeight() * caloriesPerToppingType;
    }
}
