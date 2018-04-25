package softuni.cardealer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.cardealer.model.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

//List<Customer> findAllByIdIsNotNullOrderBybOrderByBirthDate();
}