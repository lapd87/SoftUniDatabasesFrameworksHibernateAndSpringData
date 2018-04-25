package org.softuni.mostwanted.services.district;

import org.softuni.mostwanted.domain.dto.importDtos.DistrictJSONImportDto;
import org.softuni.mostwanted.domain.models.District;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository,
                               TownRepository townRepository,
                               ModelParser modelParser) {
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }

    @Override
    public String create(DistrictJSONImportDto dto) {
        String result = "";

        District district = this.districtRepository.findByNameIs(dto.getName());

        if (district != null
                && district.getTown().getName()
                .equals(dto.getTownName())) {
            return result = "Error: Duplicate Data!";
        } else {
            Town town = this.townRepository.findByName(dto.getTownName());

            district = this.modelParser.convert(dto, District.class);

            if (town != null) {
                district.setTown(town);
            }

            this.districtRepository.saveAndFlush(district);

            result = String
                    .format("Successfully imported District - %s.",
                            district.getName());
        }
        return result;
    }
}