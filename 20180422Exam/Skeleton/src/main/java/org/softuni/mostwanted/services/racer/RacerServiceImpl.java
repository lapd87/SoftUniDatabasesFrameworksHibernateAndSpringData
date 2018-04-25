package org.softuni.mostwanted.services.racer;

import org.softuni.mostwanted.domain.dto.exportDtos.RacerCarsJSONExportDto;
import org.softuni.mostwanted.domain.dto.exportDtos.TownJSONExportDto;
import org.softuni.mostwanted.domain.dto.importDtos.RacerJSONImportDto;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    private final RacerRepository racerRepository;
    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository,
                            TownRepository townRepository,
                            ModelParser modelParser) {
        this.racerRepository = racerRepository;
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }

    @Override
    public String create(RacerJSONImportDto dto) {
        String result = "";

        Racer racer = this.racerRepository.findByName(dto.getName());

        if (racer != null) {
            return result = "Error: Duplicate Data!";
        } else {

            racer = this.modelParser.convert(dto, Racer.class);

            Town town = this.townRepository.findByName(dto.getHomeTown());

            if (town != null) {
                racer.setHomeTown(town);
            }

            this.racerRepository.saveAndFlush(racer);

            result = String
                    .format("Successfully imported Racer - %s.",
                            racer.getName());
        }
        return result;
    }

    @Override
    public List<TownJSONExportDto> getRacingTowns() {
        return this.racerRepository.findRacingTowns();
    }

    @Override
    public List<RacerCarsJSONExportDto> getAllRacersCars() {

        List<Racer> racers = this.racerRepository.findAll();

        racers.sort(Comparator
                .comparing(Racer::setCarCount)
                .thenComparing(Racer::getName));

        List<RacerCarsJSONExportDto> racerCarsJSONExportDtos = new ArrayList<>();

        for (Racer racer : racers) {
            if (racer.getCars().size() == 0 || racer.getCars() != null) {
                continue;
            }

            RacerCarsJSONExportDto racerDto = new RacerCarsJSONExportDto();
            racerDto.setName(racer.getName());
            if (racer.getAge() != null) {
                racerDto.setAge(racer.getAge());
            }

            List<String> carsString = new ArrayList<>();

            for (Car car : racer.getCars()) {
                carsString.add(car.toString());
            }

            racerDto.setCars(carsString);

            racerCarsJSONExportDtos.add(racerDto);
        }

        return racerCarsJSONExportDtos;
    }
}