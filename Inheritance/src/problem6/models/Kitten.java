package problem6.models;

import problem6.enumeration.Gender;

/**
 * Created by Radoslav on 18.7.2016 г..
 */
public class Kitten extends Cat {

    public Kitten(java.lang.String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public java.lang.String produceSound() {
        return "Miau";
    }

    @Override
    public java.lang.String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName() + " " + this.getName() + " " + this.getAge() + " " + this.getGender());
        stringBuilder.append("\n" + this.produceSound());
        return stringBuilder.toString();
    }
}
