package softuni.employee;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import softuni.employee.config.ModelMapperConfig;
import softuni.employee.model.dto.EmployeeDto;
import softuni.employee.model.entity.Employee;
import softuni.employee.services.employee.EmployeeService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 09:15 ч.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        loadInitialEmployees();

        getEmployeeDto();

    }

    private void getEmployeeDto() {

        List<EmployeeDto> employeeDtos = this.employeeService
                .getAllEmployees();

        for (EmployeeDto employeeDto : employeeDtos) {
            System.out.println(employeeDto.toString());
        }

    }

    private void loadInitialEmployees() {
//          Scanner scanner = new Scanner(System.in);
//
//          String[] employeeArgs = scanner.nextLine()
//                  .split("\\s+", 4);

        String[] employeeArgs = "Pesho Stamatov 4589.55 12-11-1987 Rousse"
                .split("\\s+");


        String firstName = employeeArgs[0];
        String lastName = employeeArgs[1];
        BigDecimal salary = BigDecimal
                .valueOf(Double
                        .parseDouble(employeeArgs[2]));
        Date birtday = parseDate(employeeArgs[3]);
        String address = employeeArgs[4];


        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        employee.setBirthday(birtday);
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        registerEmployeeIntoDB(employees);
    }

    private void registerEmployeeIntoDB(Set<Employee> employees) {

        for (Employee employee : employees) {
            this.employeeService
                    .saveEmployeeIntoDB(employee);
        }

    }

    private Date parseDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date releaseDate = null;

        try {
            releaseDate = formatter.parse(date);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("d-M-yyyy");
            try {
                releaseDate = formatter.parse(date);
            } catch (ParseException e1) {
                formatter = new SimpleDateFormat("dd MMM yyyy",
                        Locale.ENGLISH);
                try {
                    releaseDate = formatter.parse(date);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }

            }
        }

        return releaseDate;
    }

}