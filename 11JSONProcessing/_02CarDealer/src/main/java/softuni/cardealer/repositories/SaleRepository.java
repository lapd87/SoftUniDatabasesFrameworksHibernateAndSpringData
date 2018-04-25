package softuni.cardealer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.cardealer.model.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {


}