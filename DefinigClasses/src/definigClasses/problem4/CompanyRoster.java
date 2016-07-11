package definigClasses.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Radoslav on 23.6.2016 г..
 */

class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    Employee(String name, double salary, String position, String department, String email){
        this(name, salary, position, department, email, -1);
    }

    Employee(String name, double salary, String position, String department, int age){
        this(name, salary, position, department, "n/a", age);
    }

    Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(employee.salary, this.salary);
    }
}

public class CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLines = Integer.parseInt(sc.readLine());
        HashMap<String, TreeSet<Employee>> departments = new HashMap<>();
        HashMap<String, Double> depWithSalary = new HashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String []tokens = sc.readLine().split("\\s+");
            Employee employee = null;
            String name = tokens[0];
            Double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            int age = 0;
            String email = "";
            if(tokens.length == 4){
                employee = new Employee(name, salary, position, department);
            }else if(tokens.length == 5){

                if(isNumber(tokens[4])){
                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }else {
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }else {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if(!departments.containsKey(department)){
                departments.put(department, new TreeSet<>());
                depWithSalary.put(department, 0D);
            }
            departments.get(department).add(employee);
            depWithSalary.put(department, depWithSalary.get(department) + salary);
        }

        Map.Entry<String, TreeSet<Employee>> best = departments.
                entrySet().
                stream().
                sorted((e1, e2) -> Double.
                        compare(depWithSalary.get(e2.getKey()),
                                depWithSalary.get(e1.getKey()))).
                findFirst().
                get();

        System.out.println("Highest Average Salary: " + best.getKey());
        for (Employee employee : best.getValue()) {
            System.out.println(employee);
        }
    }

    private static boolean isNumber(String token) {
        try{
            Integer.parseInt(token);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
