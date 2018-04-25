package org.softuni.mostwanted.services.car;

import org.softuni.mostwanted.domain.dto.importDtos.CarJSONImportDto;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final ModelParser modelParser;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          RacerRepository racerRepository,
                          ModelParser modelParser) {
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.modelParser = modelParser;
    }

    @Override
    public String create(CarJSONImportDto dto) {
        String result = "";

        Racer racer = this.racerRepository.findByName(dto.getRacerName());

        Car car = this.carRepository
                .findByBrandAndModelAndYearOfProductionAndRacer(dto.getBrand(), dto.getModel(), dto.getYearOfProduction(), racer);

        if (car != null) {
            return result = "Error: Duplicate Data!";
        } else if (dto.getRacerName() != null && racer == null) {
            return result = "Error: Incorrect Data!!";
        } else {
            car = this.modelParser.convert(dto, Car.class);

            if (racer != null) {
                car.setRacer(racer);
            }

            this.carRepository.saveAndFlush(car);

            racer.getCars().add(car);

            this.racerRepository.saveAndFlush(racer);

            result = String
                    .format("Successfully imported Car - %s %s @ %d.",
                            car.getBrand(),
                            car.getModel(),
                            car.getYearOfProduction());
        }
        return result;
    }
}