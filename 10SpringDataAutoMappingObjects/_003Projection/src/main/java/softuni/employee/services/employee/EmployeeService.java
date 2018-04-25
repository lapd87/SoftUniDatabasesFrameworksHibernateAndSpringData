package softuni.employee.services.employee;

import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.entity.Employee;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface EmployeeService {

    void saveEmployeeIntoDB(Employee employee);

    Employee getById(Long id);

    List<EmployeeDto> getByBirthdayBeforeOrderBySalaryDesc(Date date);
}