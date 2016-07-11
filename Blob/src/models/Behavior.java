package models;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
public abstract class Behavior {
    private boolean isTriggered;
    private String behaviorType;

    public Behavior(String behaviorType) {
        this.setBehaviorType(behaviorType);
        this.setTriggered(isTriggered);
    }

    public boolean isTriggered() {
        return isTriggered;
    }

    public void setTriggered(boolean triggered) {
        isTriggered = triggered;
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public void triggerBehavior(Blob blob){
        if(blob.getHealth() <= 0.5 * blob.getInitialHealth()){
            this.setTriggered(true);
        }
    }
}
