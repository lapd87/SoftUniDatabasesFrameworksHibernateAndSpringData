package softuni.employee.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.entity.Employee;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 09:12 ч.
 */
public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    public ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.initialize();
    }

    private void initialize() {
        employeeWithManagerNameMapping();
    }

    private void employeeWithManagerNameMapping() {
        this.modelMapper
                .createTypeMap(Employee.class, EmployeeDto.class)
                .addMappings(mapper ->
                        mapper.map(src -> src
                                        .getManager()
                                        .getLastName(),
                                EmployeeDto::setManagerLastName));
    }
}