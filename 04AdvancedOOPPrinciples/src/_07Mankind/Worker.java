package _07Mankind;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 19:03 ч.
 */

public class Worker extends Human {


    private Double weekSalary;
    private Double workHoursPerDay;


    public Worker(String firstName, String lastName,
                  Double weekSalary, Double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWorkHoursPerDay(Double workHoursPerDay) {

        if (workHoursPerDay < 1 || workHoursPerDay > 12 || workHoursPerDay == null) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workHoursPerDay = workHoursPerDay;

    }

    private void setWeekSalary(Double weekSalary) {
        if (weekSalary < 10 || weekSalary == null) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.weekSalary = weekSalary;
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() <= 3) {

            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public Double getWeekSalary() {
        return weekSalary;
    }

    public Double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public Double getSalaryPerHour() {
        return getWeekSalary() / getWorkHoursPerDay() / 7.0;
    }

    @Override
    public String toString() {
        return
                String.format("%s%nWeek Salary: %.2f%n" +
                                "Hours per day: %.2f%n" +
                                "Salary per hour: %.2f",
                        super.toString(), this.getWeekSalary(),
                        this.getWorkHoursPerDay(), this.getSalaryPerHour());
    }
}