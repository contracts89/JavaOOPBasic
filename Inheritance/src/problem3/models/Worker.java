package problem3.models;

/**
 * Created by Radoslav on 17.7.2016 г..
 */
public class Worker extends Human {
    private double weekSalary;
    private double workingHours;

    public Worker(String firstName, String lastName, double weekSalary, double workingHours) {
        super(firstName, lastName);
        this.setworkingHours(workingHours);
        this.setWeekSalary(weekSalary);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkingHours() {
        return workingHours;
    }

    private void setworkingHours(double workingHours) {
        if(workingHours < 1 || workingHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    private double calcMoneyPerHour(){
        return this.getWeekSalary() / (this.getWorkingHours() * 7);
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s\nLast Name: %s\nWeek Salary: %.2f\nHours per day: %.2f\nSalary per hour: %.2f",
                this.getFirstName(),
                this.getLastName(),
                this.getWeekSalary(),
                this.getWorkingHours(),
                this.calcMoneyPerHour()));
        return sb.toString();
    }
}
