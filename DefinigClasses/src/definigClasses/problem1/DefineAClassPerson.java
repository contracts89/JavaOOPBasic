package definigClasses.problem1;

import java.lang.reflect.Field;

/**
 * Created by Radoslav on 23.6.2016 г..
 */
class Person{
    String name;
    int age;
}

public class DefineAClassPerson {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        Person stamat = new Person();
        Person gosho = new Person();
        Person pesho = new Person();
        stamat.name = "Stamat";
        gosho.name = "Gosho";
        pesho.name = "Pesho";
        pesho.age = 20;
        gosho.age = 18;
        stamat.age = 43;
    }
}
