package models;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
public class AggressiveBehavior extends Behavior {

    public AggressiveBehavior(String behaviorType) {
        super(behaviorType);
    }

    @Override
    public void triggerBehavior(Blob blob) {
        super.triggerBehavior(blob);
        blob.setDamage(blob.getDamage() * 2);
    }
}
