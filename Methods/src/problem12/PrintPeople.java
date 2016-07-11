package problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.TransferQueue;

/**
 * Created by Radoslav on 8.7.2016 г..
 */

class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.setName(name);
        this.setAge(age);
        this.setOccupation(occupation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s",
                this.getName(),
                this.getAge(),
                this.getOccupation());
    }

    @Override
    public int compareTo(Person otherPerson) {
        int result = 0;
        if(otherPerson.getAge() == this.getAge()){
            result = 0;
        } else if(this.getAge() > otherPerson.getAge()){
            result = 1;
        }else {
            result = -1;
        }

        return result;
    }
}

public class PrintPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> people = new ArrayList<>();
        while(true){
            String[] tokens = sc.readLine().split("\\s+");
            if(tokens[0].equals("END")){
                break;
            }
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String occupation = tokens[2];
            Person person = new Person(name, age, occupation);
            people.add(person);
        }

        people.stream().sorted(Person::compareTo).forEach(System.out::println);

    }
}
