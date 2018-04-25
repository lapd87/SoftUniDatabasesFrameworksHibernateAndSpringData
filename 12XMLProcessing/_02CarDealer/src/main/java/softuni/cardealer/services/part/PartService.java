package softuni.cardealer.services.part;

import softuni.cardealer.model.dto.binding.PartSeedDto;
import softuni.cardealer.model.entity.Part;

import java.util.Collection;

public interface PartService {

    void saveWithRandomSupplier(Collection<PartSeedDto> partsSeedDto);

    void saveWithRandomSupplier(PartSeedDto partSeedDto);

    Part getById(Long id);
}