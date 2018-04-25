package org.softuni.mostwanted.services.raceEntry;

import org.softuni.mostwanted.domain.dto.importDtos.RaceEntryXMLImportDto;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.RaceEntry;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryrepository;
    private final ModelParser modelParser;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryrepository,
                                ModelParser modelParser,
                                CarRepository carRepository,
                                RacerRepository racerRepository) {
        this.raceEntryrepository = raceEntryrepository;
        this.modelParser = modelParser;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
    }

    @Override
    public String create(RaceEntryXMLImportDto dto) {
        String result = "";

        Car car = this.carRepository
                .getOne(dto.getCar());
        Racer racer = this.racerRepository
                .findByName(dto.getRacer());

        if ((dto.getCar() != null && car == null)
                || (dto.getRacer() != null && racer == null)) {
            return result = "Error: Incorrect Data!!";
        } else {

            RaceEntry raceEntry = this.modelParser.convert(dto, RaceEntry.class);

            this.raceEntryrepository.saveAndFlush(raceEntry);

            result = String
                    .format("Successfully imported RaceEntry - %d.",
                            raceEntry.getId());
        }
        return result;
    }
}