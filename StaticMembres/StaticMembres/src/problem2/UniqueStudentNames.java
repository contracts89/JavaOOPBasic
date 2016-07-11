package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by Radoslav on 9.7.2016 г..
 */
class Student{
    private String name;

    public Student(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StudentGroup{
    HashSet<Student> allStudents;
    static int uniqueCount = 0;

    public StudentGroup() {
        this.allStudents = new HashSet<>();
    }

    public void addStudent(Student student){
        boolean isContained = false;
        for (Student student1 : this.allStudents) {
            if(student1.getName().equals(student.getName())){
                isContained = true;
            }
        }
        if(!isContained){
            uniqueCount++;
        }
        this.allStudents.add(student);
    }
}

public class UniqueStudentNames {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StudentGroup studentGroup = new StudentGroup();
        while(true){
            String line = sc.readLine();
            if (line.equals("End")){
                break;
            }
            Student student = new Student(line);

            studentGroup.addStudent(student);
        }

        System.out.println(StudentGroup.uniqueCount);
    }
}
