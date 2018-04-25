package _07Mankind;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:58 ч.
 */

public class Student extends Human {

    private String facultyNumber;


    public Student(String firstName, String lastName,
                   String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }



    private void setFacultyNumber(String facultyNumber) {

        if (facultyNumber.length() < 5 || facultyNumber.length() > 10 || !facultyNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        return
                String.format("%s%nFaculty number: %s",
                        super.toString(), this.getFacultyNumber());
    }
}