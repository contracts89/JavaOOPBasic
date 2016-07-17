package problem3;

import problem3.models.Student;
import problem3.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 17.7.2016 г..
 */
public class Mankind {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLIne = sc.readLine().split("\\s+");
        String studentFirstName = firstLIne[0];
        String studentLastName = firstLIne[1];
        String facNum = firstLIne[2];

        String[] secondLine = sc.readLine().split("\\s+");
        String workerFirstName = secondLine[0];
        String workerLastName = secondLine[1];
        double weekSalary = Double.parseDouble(secondLine[2]);
        double workingHoursPerDay = Double.parseDouble(secondLine[3]);
        try{
            Student student = new Student(studentFirstName, studentLastName, facNum);
            Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, workingHoursPerDay);

            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
