package org.softuni.mostwanted.services.race;

import org.softuni.mostwanted.domain.dto.importDtos.RaceEntryXMLImportIdDto;
import org.softuni.mostwanted.domain.dto.importDtos.RaceXMLImportDto;
import org.softuni.mostwanted.domain.models.District;
import org.softuni.mostwanted.domain.models.Race;
import org.softuni.mostwanted.domain.models.RaceEntry;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final DistrictRepository districtRepository;
    private final ModelParser modelParser;
    private final RaceEntryRepository raceEntryRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository,
                           DistrictRepository districtRepository,
                           ModelParser modelParser,
                           RaceEntryRepository raceEntryRepository) {
        this.raceRepository = raceRepository;
        this.districtRepository = districtRepository;
        this.modelParser = modelParser;
        this.raceEntryRepository = raceEntryRepository;
    }

    @Override
    public String create(RaceXMLImportDto dto) {
        String result = "";

        List<District> district = this.districtRepository
                .findByName(dto.getDistrictName());

        if (district.size() == 0) {
            return result = "Error: Incorrect Data!!";
        }

        Set<RaceEntryXMLImportIdDto> entries = dto.getEntries();

        for (RaceEntryXMLImportIdDto entry : entries) {
            RaceEntry raceEntry = this.raceEntryRepository.getOne(entry.getId());

            if (raceEntry == null) {
                return result = "Error: Incorrect Data!!";
            }
        }

        Race race = this.modelParser.convert(dto, Race.class);

        race.setDistrict(district.get(0));

        this.raceRepository.saveAndFlush(race);

        result = String
                .format("Successfully imported Race - %d.",
                        race.getId());

        return result;
    }
}