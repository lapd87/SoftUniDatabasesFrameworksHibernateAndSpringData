package softuni.cardealer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.cardealer.model.entity.Part;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {

    Part findByIdIs(Long id);

}