package softuni.employee.services.employee;

import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.entity.Employee;
import softuni.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.employee.util.EmployeeDtoConvertUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployeeIntoDB(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees =
                this.employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDto employeeDto = EmployeeDtoConvertUtil
                    .convert(employee, EmployeeDto.class);

            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }
}