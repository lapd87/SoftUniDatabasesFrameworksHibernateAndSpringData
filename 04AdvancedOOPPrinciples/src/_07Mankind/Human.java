package _07Mankind;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 12:07 ч.
 */

public class Human implements Namable {

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
       this.setFirstName(firstName);
        this.setLastName(lastName);
    }


    public void setLastName(String lastName) {


        if (lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: lastName");
        }

        this.lastName = lastName;

    }

    private void setFirstName(String firstName) {

        if (firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;

    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s",
                this.firstName, this.lastName);
    }
}