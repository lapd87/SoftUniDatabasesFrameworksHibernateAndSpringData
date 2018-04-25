package softuni.employee.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.employee.model.entity.Employee;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

}