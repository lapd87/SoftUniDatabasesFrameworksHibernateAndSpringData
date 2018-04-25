package softuni.cardealer.services.part;

import org.modelmapper.ModelMapper;
import softuni.cardealer.model.dto.binding.PartSeedDto;
import softuni.cardealer.model.entity.Part;
import softuni.cardealer.model.entity.Supplier;
import softuni.cardealer.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.cardealer.repositories.SupplierRepository;

import java.util.Collection;
import java.util.Random;

import static softuni.cardealer.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void saveWithRandomSupplier(Collection<PartSeedDto> partsSeedDto) {
        partsSeedDto.forEach(this::saveWithRandomSupplier);
    }

    @Override
    public void saveWithRandomSupplier(PartSeedDto partSeedDto) {

        Part part = modelMapper
                .map(partSeedDto, Part.class);

        int supplierCount = this.supplierRepository
                .findAll().size();

        Random random = new Random();

        long supplierId = random
                .nextInt(supplierCount) + 1;

        Supplier supplier = this.supplierRepository
                .findByIdIs(supplierId);

        part.setSupplier(supplier);

        this.partRepository
                .saveAndFlush(part);
    }

    @Override
    public Part getById(Long id) {
        return this.partRepository
                .findByIdIs(id);
    }
}