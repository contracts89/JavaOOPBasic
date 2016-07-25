package problem4;

import problem4.contracts.Food;

import java.util.ArrayList;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class Gandalf {
    private ArrayList<Food> foods;
    private int moodScore;
    private Mood mood;

    public Gandalf() {
        this.setFoods(new ArrayList<>());
        this.setMoodScore(moodScore);
    }

    private ArrayList<Food> getFoods() {
        return foods;
    }

    private void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    private Mood getMood() {
        return mood;
    }

    private void setMood(Mood mood) {
        this.mood = mood;
    }

    private int getMoodScore() {
        return moodScore;
    }

    private void setMoodScore(int moodScore) {
        this.moodScore = moodScore;
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    public void calcMoodScore(){
        int moodScore = 0;
        for (Food food : this.getFoods()) {
            moodScore += food.getPointsOfHappyness();
        }
        this.setMoodScore(moodScore);
    }

    public void setGandalfMood(){
        int score = this.getMoodScore();
        if(score < -5){
            this.setMood(Mood.Angry);
        }else if(score >= -5 && score <= 0){
            this.setMood(Mood.Sad);
        }else if(score > 0 && score < 15){
            this.setMood(Mood.Happy);
        }else {
            this.setMood(Mood.JavaScript);
        }
    }

    @Override
    public String toString() {
        return this.getMoodScore() + "\n" + this.getMood();
    }
}
