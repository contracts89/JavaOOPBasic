package wildFarm.foodModels;

/**
 * Created by Radoslav on 23.7.2016 г..
 */
public abstract class Food {
    private int quatity;

    public Food(int quatity) {
        this.quatity = quatity;
    }

    public int getQuatity() {
        return quatity;
    }

    protected void setQuatity(int quatity) {
        this.quatity = quatity;
    }
}
