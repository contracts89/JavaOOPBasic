package definigClasses.problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Radoslav on 2.7.2016 г..
 */
class Person {
    String name;
    String birthDate;
    ArrayList<Person> parents;
    ArrayList<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder parentSb = new StringBuilder();
        for (Person parent : parents) {
            parentSb.append(parent + "\n");
        }
        StringBuilder childSb = new StringBuilder();
        for (Person child : children) {
            childSb.append(child + "\n");
        }
        return String.format("%s %s%nParents:%n%sChildren:%n%s", this.name, this.birthDate, parentSb, childSb);
    }
}

public class FamilyTree {
    private static FamilyTree ourInstance = new FamilyTree();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        ArrayList<Person>persons = new ArrayList<>();
        ArrayList<String> otherInput = new ArrayList<>();
        String[] tokens = new String[3];
        String[] otherTokens = new String [2];
        while (true) {
            Person person = null;
            String input = sc.readLine();

            if (input.equals("End")) {
                break;
            }
            if (input.contains("-")) {
                otherInput.add(input);
            //If it is person date
            }else {
                tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthday = tokens[2];
                person = new Person(name, birthday);
                persons.add(person);
            }
        }

        for (String toke : otherInput) {
            otherTokens = toke.split("\\-");
            Person parent = new Person("", "");
            Person child = new Person("", "");
            //If it is date - date
            if(otherTokens[0].contains("/") && otherTokens[1].contains("/")){
                String firstDate = otherTokens[0].trim();
                String secondDate = otherTokens[1].trim();
                for (Person person : persons) {
                    if(firstDate.equals(person.birthDate)) {
                        parent.birthDate = firstDate;
                        child.birthDate = secondDate;
                    }else if(secondDate.equals(person.birthDate)){
                        parent.birthDate = firstDate;
                        person.parents.add(parent);
                    }
                }
                //If it is name - date
            }else if(!otherTokens[0].contains("/") && otherTokens[1].contains("/")){
                String[] firstPart = otherTokens[0].split("\\s+");
                String name = firstPart[0] + " " + firstPart[1].trim();
                String childDate = otherTokens[1].trim();
                parent.name = name;
                child.birthDate = childDate;
                for (Person person : persons) {
                    if (person.name.equals(name)) {
                        person.children.add(child);
                    }
                    if(person.birthDate.equals(childDate)){
                        parent.name = name;
                        person.parents.add(parent);
                    }
                }
            }else{
                String parentName = otherTokens[0].trim();
                String childName = otherTokens[1].trim();
                for (Person person : persons) {
                    if(person.name.equals(parentName)){
                        child.name = childName;
                        person.children.add(child);
                    }
                    if(person.name.equals(childName)){
                        parent.name = parentName;
                        person.parents.add(parent);
                    }
                }
            }
        }

        for (Person person : persons) {
            if(person.name.equals(line)){
                System.out.println(person.toString());
            }
        }
    }
}
