package models;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
public class Blob {
    private String name;
    private int health;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int initialHealth;
    private int initialDamage;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {

        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setBehavior(behavior);
        this.setAttack(attack);
        this.setInitialHealth(health);
        this.setInitialDamage(damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public int getInitialHealth(){
        return initialHealth;
    }

    private void setInitialHealth(int initialHealth){
        this.initialHealth = initialHealth;
    }

    public int getInitialDamage() {
        return initialDamage;
    }

    public void setInitialDamage(int initialDamage) {
        this.initialDamage = initialDamage;
    }
}
