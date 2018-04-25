package softuni.cardealer.services.supplier;

import org.modelmapper.ModelMapper;
import softuni.cardealer.model.dto.binding.SupplierSeedDto;
import softuni.cardealer.model.dto.view.SupplierPartsCountDto;
import softuni.cardealer.model.entity.Supplier;
import softuni.cardealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static softuni.cardealer.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @Override
    public void save(Collection<SupplierSeedDto> suppliersSeedDto) {
        suppliersSeedDto.forEach(this::save);
    }

    @Override
    public void save(SupplierSeedDto supplierSeedDto) {
        Supplier supplier = modelMapper
                .map(supplierSeedDto, Supplier.class);

        this.supplierRepository
                .saveAndFlush(supplier);
    }

    @Override
    public Supplier getById(Long id) {

        return this.supplierRepository
                .findByIdIs(id);
    }

    @Override
    public Set<SupplierPartsCountDto> getLocalSuppliersWithPartsCount() {

        Set<Supplier> suppliers = this.supplierRepository
                .findAllByImporterFalse();

        Set<SupplierPartsCountDto> suppliersPartsCountDto = new HashSet<>();

        for (Supplier supplier : suppliers) {

            SupplierPartsCountDto supplierPartsCountDto = new SupplierPartsCountDto();

            supplierPartsCountDto.setId(supplier.getId());
            supplierPartsCountDto.setName(supplier.getName());

            int partsCount = supplier.getParts().size();

            supplierPartsCountDto.setPartsCount(partsCount);

            suppliersPartsCountDto.add(supplierPartsCountDto);
        }


        return suppliersPartsCountDto;
    }
}