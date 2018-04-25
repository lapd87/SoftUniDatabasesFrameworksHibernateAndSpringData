package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.cardealer.model.dto.view.SupplierPartsCountDto;
import softuni.cardealer.model.entity.Supplier;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Supplier findByIdIs(Long id);

    @Query("select new softuni.cardealer.model.dto.view.SupplierPartsCountDto(s.id,s.name,count (p))" +
            " from Supplier as s inner join s.parts as p group by s.id")
    Set<SupplierPartsCountDto> findAllByImporterFalse();
}