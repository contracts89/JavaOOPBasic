package wildFarm.animalModels.predators;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public class Cat extends Felime {
    private String breed;


    public Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                FORMAT.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
