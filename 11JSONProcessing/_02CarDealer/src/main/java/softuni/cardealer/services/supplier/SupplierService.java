package softuni.cardealer.services.supplier;

import softuni.cardealer.model.dto.binding.SupplierSeedDto;
import softuni.cardealer.model.dto.view.SupplierPartsCountDto;
import softuni.cardealer.model.entity.Supplier;

import java.util.Collection;
import java.util.Set;

public interface SupplierService {
    void save(Collection<SupplierSeedDto> suppliersSeedDto);

    void save(SupplierSeedDto supplierSeedDto);

    Supplier getById(Long id);

    Set<SupplierPartsCountDto> getLocalSuppliersWithPartsCount();
}