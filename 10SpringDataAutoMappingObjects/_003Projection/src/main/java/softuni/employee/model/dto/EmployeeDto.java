package softuni.employee.model.dto;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.4.2018 г.
 * Time: 15:21 ч.
 */
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String managerLastName;


    public EmployeeDto() {
    }

    public EmployeeDto(String firstName,
                       String lastName,
                       BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }


    @Override
    public String toString() {
        if (managerLastName == null) {
            return String.format("%s %s %.2f - Manager: [no manager]%n",
                    firstName,
                    lastName,
                    salary,
                    managerLastName);
        } else {
            return String.format("%s %s %.2f - Manager: %s%n",
                    firstName,
                    lastName,
                    salary,
                    managerLastName);
        }
    }
}