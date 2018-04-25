package softuni.employee.services.employee;

import org.modelmapper.ModelMapper;
import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.entity.Employee;
import softuni.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveEmployeeIntoDB(Employee employee) {
        this.employeeRepository.save(employee);
    }


    @Override
    public Employee getById(Long id) {
        return this.employeeRepository
                .findById(id);
    }

    @Override
    public List<EmployeeDto> getByBirthdayBeforeOrderBySalaryDesc(Date date) {

        List<Employee> employeesBornBefore = this.employeeRepository
                .findByBirthdayBeforeOrderBySalaryDesc(date);

        List<EmployeeDto> employeeBornBeforeDtos = new ArrayList<>();

        for (Employee employee : employeesBornBefore) {

            EmployeeDto employeeDto = this.modelMapper
                    .map(employee, EmployeeDto.class);

            employeeBornBeforeDtos.add(employeeDto);
        }

        return employeeBornBeforeDtos;
    }
}

