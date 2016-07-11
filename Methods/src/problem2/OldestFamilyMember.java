package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Family{
    ArrayList<Person> persons = new ArrayList<>();

    public Family() {
        this.persons = new ArrayList<>();
    }

    public void addMember(Person member){
        this.persons.add(member);
    }

    public void getOldestMember(){
        int currAge = persons.get(0).age;
        int nextAge = 0;
        for (int i = 1; i < persons.size(); i++) {
            nextAge = persons.get(i).age;
            if(currAge < nextAge){
                currAge = nextAge;
            }
        }
        for (Person person : persons) {
            if(person.age == currAge){
                System.out.println(person.name + " " + person.age);
            }
        }
    }
}
public class OldestFamilyMember {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        Family family = new Family();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);

            family.addMember(person);
        }

        family.getOldestMember();
    }
}
