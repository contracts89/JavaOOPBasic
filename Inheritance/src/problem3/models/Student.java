package problem3.models;

/**
 * Created by Radoslav on 17.7.2016 г..
 */
public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
    //    StringBuilder sb = new StringBuilder();
    //    sb.append(String.format("First Name: %s\nLast Name: %s\nFaculty number: %s",
    //            this.getFirstName(),
    //            this,getLastName(),
    //            this.getFacultyNumber()));
    //    return sb.toString();
        return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nFaculty number: " + this.getFacultyNumber();
    }
}
