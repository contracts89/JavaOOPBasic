package problem6;

/**
 * Created by Radoslav on 14.7.2016 г..
 */
public class Player {
    private static final int STATS_COUNT = 5;
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;
    private double averageStats;


    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
        this.setAverageStats(averageStats);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.equals("")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private double getEndurance() {
        return endurance;
    }

    private void setEndurance(double endurance) {
        if(endurance < 0 || endurance > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100. ");
        }
        this.endurance = endurance;
    }

    private double getSprint() {
        return sprint;
    }

    private void setSprint(double sprint) {
        if(sprint < 0 || sprint > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private double getDribble() {
        return dribble;
    }

    private void setDribble(double dribble) {
        if(dribble < 0 || dribble > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private double getPassing() {
        return passing;
    }

    private void setPassing(double passing) {
        if(passing < 0 || passing > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private double getShooting() {
        return shooting;
    }

    private void setShooting(double shooting) {
        if(shooting < 0 || shooting > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    private double calcAverageStats(){
        return (this.getDribble() +
                this.getEndurance() +
                this.getPassing() +
                this.getShooting() +
                this.getSprint()) /
                STATS_COUNT;
    }

    private void setAverageStats(double averageStats) {
        this.averageStats = this.calcAverageStats();
    }

    public double getAverageStats(){
        return averageStats;
    }
}
