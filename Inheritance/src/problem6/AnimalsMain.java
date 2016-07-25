package problem6;

import problem6.enumeration.Gender;
import problem6.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static problem6.enumeration.Gender.Female;
import static problem6.enumeration.Gender.Male;

/**
 * Created by Radoslav on 18.7.2016 г..
 */
public class AnimalsMain {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String firstLine = sc.readLine();
            if(firstLine.equals("Beast!")){
                break;
            }

            String[] secondLine = sc.readLine().split("\\s+");
            String name = secondLine[0];
            int age = Integer.parseInt(secondLine[1]);
            String gender = secondLine[2];

            try{
                Animal animal = null;
                Gender animalGender = null;
                switch (gender.toLowerCase()){
                    case "male":
                        animalGender = Male;
                        break;
                    case "female":
                        animalGender = Female;
                        break;
                }

                switch (firstLine.toLowerCase()){
                    case "kitten":
                        animal = new Kitten(name, age, Female);
                        break;
                    case "tomcat":
                        animal = new Tomcat(name, age, Male);
                        break;
                    case "cat":
                        if(gender.equalsIgnoreCase("male")){
                            animal = new Cat(name, age, Male);
                        }else if(gender.equalsIgnoreCase("female")){
                            animal = new Cat(name, age, Female);
                        }else {
                            throw new IllegalArgumentException("Invalid input!");
                        }
                        break;
                    case "dog":
                        animal = new Dog(name, age, animalGender);
                        break;
                    case "frog":
                        animal = new Frog(name, age, animalGender);
                        break;
                }

                System.out.println(animal.toString());

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

