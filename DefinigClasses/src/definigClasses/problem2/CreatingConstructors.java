package definigClasses.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

/**
 * Created by Radoslav on 23.6.2016 г..
 */
class Person {
    String name;
    int age;

    Person (String name, int age){
        this.name = name;
        this.age = age;
    }
    Person (){
        this("No name", 1);
    }
    Person (int age){
        this("No name", age);
    }
}

public class CreatingConstructors {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personFull = (Person) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }

}
