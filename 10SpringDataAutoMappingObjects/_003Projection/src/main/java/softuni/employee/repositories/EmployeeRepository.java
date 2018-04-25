package softuni.employee.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.employee.model.entity.Employee;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Employee findById(Long id);

    List<Employee> findByBirthdayBeforeOrderBySalaryDesc(Date date);


}