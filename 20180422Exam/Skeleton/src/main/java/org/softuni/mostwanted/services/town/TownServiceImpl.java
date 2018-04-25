package org.softuni.mostwanted.services.town;

import org.softuni.mostwanted.domain.dto.importDtos.TownJSONImportDto;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelParser modelParser) {
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }

    @Override
    public String create(TownJSONImportDto dto) {
        String result = "";

        Town town = this.townRepository.findByName(dto.getName());

        if (town != null) {
            return result = "Error: Duplicate Data!";
        } else {
            town = this.modelParser.convert(dto, Town.class);

            this.townRepository.saveAndFlush(town);

            result = String
                    .format("Successfully imported Town - %s.",
                            town.getName());
        }
        return result;
    }
}