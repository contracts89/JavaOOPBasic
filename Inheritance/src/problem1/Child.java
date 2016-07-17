package problem1;

/**
 * Created by Radoslav on 17.7.2016 г..
 */
public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if(age > 15){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
