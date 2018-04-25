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

    @Query(value = "select s.* from Suppliers as s where s.is_importer=0", nativeQuery = true)
    Set<Supplier> findAllByImporterFalse();
}