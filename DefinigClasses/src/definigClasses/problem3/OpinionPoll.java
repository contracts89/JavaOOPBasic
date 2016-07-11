package definigClasses.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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


public class OpinionPoll {
    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<>();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLines = Integer.parseInt(sc.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String [] input = sc.readLine().split("\\s");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if(age > 30){
                persons.add(new Person(name, age));
            }
        }
        persons.sort((p1, p2) -> p1.name.compareTo(p2.name));
        for (Person person : persons) {
            System.out.printf("%s - %d%n", person.name, person.age);
        }
    }
}
