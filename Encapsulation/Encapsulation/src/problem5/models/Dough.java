package problem5.models;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class Dough {
    private static final int BASE_CALORIES_PER_GRAM = 2;
    private String flourType;
    private String bakingTechnique;
    private double doughWeight;

    public Dough(String flourType, String bakingTechnique, double doughWeight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setDoughWeight(doughWeight);
    }

    private static int getBaseCaloriesPerGram() {
        return BASE_CALORIES_PER_GRAM;
    }

    private String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if(!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if((!bakingTechnique.equalsIgnoreCase("crispy")) && (!bakingTechnique.equalsIgnoreCase("chewy")) && (!bakingTechnique.equalsIgnoreCase("homemade"))){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private double getDoughWeight() {
        return doughWeight;
    }

    private void setDoughWeight(double doughWeight) {
        if(doughWeight < 1 || doughWeight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.doughWeight = doughWeight;
    }

    public double getCaloriesPerGram(){
        double caloriesPerTypeOfFlour = 0L;
        switch (this.getFlourType().toLowerCase()){
            case "white":
                caloriesPerTypeOfFlour = 1.5;
                break;
            case "wholegrain":
                caloriesPerTypeOfFlour = 1.0;
        }

        double caloriesPerBakingTechnique = 0L;
        switch (this.getBakingTechnique().toLowerCase()){
            case "crispy":
                caloriesPerBakingTechnique = 0.9;
                break;
            case "chewy":
                caloriesPerBakingTechnique = 1.1;
                break;
            case "homemade":
                caloriesPerBakingTechnique = 1.0;
                break;
        }
        return (BASE_CALORIES_PER_GRAM * this.getDoughWeight()) * caloriesPerTypeOfFlour * caloriesPerBakingTechnique;
    }
}
