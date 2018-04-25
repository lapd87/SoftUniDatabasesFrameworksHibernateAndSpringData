package softuni.employee.services.employee;

import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.dto.ManagerDto;
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
    public Set<ManagerDto> getAllManagers() {
        Set<Employee> employees = this.employeeRepository
                .findByManagerIsNull();

        Set<ManagerDto> managerDtos = new HashSet<>();

        for (Employee employee : employees) {
            ManagerDto managerDto = EmployeeDtoConvertUtil
                    .convert(employee, ManagerDto.class);

            managerDtos.add(managerDto);
        }
        return managerDtos;
    }

    @Override
    public Set<EmployeeDto> getAllByManagerId(Long id) {
        Set<Employee> employeesByManager = this.employeeRepository
                .findByManagerIs(id);

        Set<EmployeeDto> employeesByManagerDto = new HashSet<>();

        for (Employee employee : employeesByManager) {
            EmployeeDto employeeDto = EmployeeDtoConvertUtil
                    .convert(employee, EmployeeDto.class);

            employeesByManagerDto.add(employeeDto);
        }

        return employeesByManagerDto;
    }

    @Override
    public Employee getById(Long id) {
        return this.employeeRepository
                .findById(id);
    }

}