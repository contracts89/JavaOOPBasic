package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodSaysHello {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String name = sc.readLine();
        Person person = new Person(name);
        person.sayHello();
    }
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.printf("%s says \"Hello\"!", this.name);
    }
}