package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 9.7.2016 г..
 */
class Student{
    String name;
    static int studentsCount = 0;

    public Student(String name) {
        this.name = name;
        Student.studentsCount += 1;
    }
}
public class Students {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = sc.readLine();
            if(line.equals("End")){
                break;
            }

            Student student = new Student(line);
        }
        System.out.println(Student.studentsCount);
    }
}
