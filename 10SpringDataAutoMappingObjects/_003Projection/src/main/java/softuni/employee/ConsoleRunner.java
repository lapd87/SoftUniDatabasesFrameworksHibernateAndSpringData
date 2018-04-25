package softuni.employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {

        loadInitialEmployees();

        getEmployeesBornBefore1990OrderBySalaryDesc();

    }

    private void getEmployeesBornBefore1990OrderBySalaryDesc() {

        String dateString = "01/01/1990";

        Date date = parseDate(dateString);

        List<EmployeeDto> employeeBornBeforeDtos = this.employeeService
                .getByBirthdayBeforeOrderBySalaryDesc(date);

        for (EmployeeDto employeeDto : employeeBornBeforeDtos) {

            System.out.println(employeeDto.toString());
        }

    }

    private void loadInitialEmployees() {
//          Scanner scanner = new Scanner(System.in);
//
//          String[] employeeArgs = scanner.nextLine()
//                  .split("\\s+", 4);

        List<String> input = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            String inputArgs0 = "Pesho" + i;
            String inputArgs1 = "Stamatov" + i;
            String inputArgs2 = "11/11/" + (1987 + i);
            String inputArgs3 = String
                    .valueOf(i * 9999.99);
            String inputArgs4 = "false";
            if (i % 3 == 0)
                inputArgs4 = "true";
            String inputArgs5 = "Rousse" + i;

            String inputArgs = inputArgs0 + " "
                    + inputArgs1 + " "
                    + inputArgs2 + " "
                    + inputArgs3 + " "
                    + inputArgs4 + " "
                    + inputArgs5;

            input.add(inputArgs);

        }

        for (String inputArg : input) {

            String[] employeeArgs = inputArg
                    .split("\\s+");

            String firstName = employeeArgs[0];
            String lastName = employeeArgs[1];
            Date birtday = parseDate(employeeArgs[2]);
            BigDecimal salary = BigDecimal
                    .valueOf(Double
                            .parseDouble(employeeArgs[3]));
            boolean isOnHoliday = Boolean
                    .valueOf(employeeArgs[4]);
            String address = employeeArgs[5];


            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setBirthday(birtday);
            employee.setSalary(salary);
            employee.setOnHoliday(isOnHoliday);
            employee.setAddress(address);

            if (!firstName.equals("Pesho0")) {
                employee
                        .setManager(this.employeeService
                                .getById(1L));
            }

            Set<Employee> employees = new HashSet<>();
            employees.add(employee);

            registerEmployeeIntoDB(employees);
        }

        Employee manager = this.employeeService
                .getById(1L);

        for (int i = 2; i <= 5; i++) {

            manager
                    .getWorkers()
                    .add(this.employeeService
                            .getById((long) i));
        }

        Set<Employee> managers = new HashSet<>();
        managers.add(manager);

        registerEmployeeIntoDB(managers);
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