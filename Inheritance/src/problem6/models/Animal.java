package problem6.models;

import problem6.contracts.ISoundProducable;
import problem6.enumeration.Gender;

/**
 * Created by Radoslav on 18.7.2016 г..
 */
public abstract class Animal implements ISoundProducable {
    private java.lang.String name;
    private int age;
    private Gender gender;

    public Animal(java.lang.String name, int age, Gender gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    protected java.lang.String getName() {
        return name;
    }

    protected void setName(java.lang.String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected Gender getGender() {
        return gender;
    }

    protected void setGender(Gender gender) {

        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }
}
