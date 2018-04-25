package softuni.employee.services.employee;

import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.dto.ManagerDto;
import softuni.employee.model.entity.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {

    void saveEmployeeIntoDB(Employee employee);

    Employee getById(Long id);

    Set<ManagerDto> getAllManagers();

    Set<EmployeeDto> getAllByManagerId(Long id);
}