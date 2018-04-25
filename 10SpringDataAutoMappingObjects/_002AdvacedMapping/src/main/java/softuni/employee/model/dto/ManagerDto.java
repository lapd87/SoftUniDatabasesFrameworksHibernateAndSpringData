package softuni.employee.model.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 11:50 ч.
 */
public class ManagerDto {

    private String firstName;
    private String lastName;
    private Set<EmployeeDto> workers;

    public ManagerDto() {
        this.workers = new HashSet<>();
    }

    public ManagerDto(String firstName,
                      String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<EmployeeDto> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeDto> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        StringBuilder managerDtoToString = new StringBuilder();

        managerDtoToString.append(String.format("%s %s | Employees: %d%n",
                firstName,
                lastName,
                workers.size()));

        for (EmployeeDto worker : workers) {
            managerDtoToString.append(worker.toString());
        }

        return managerDtoToString.toString();
    }
}