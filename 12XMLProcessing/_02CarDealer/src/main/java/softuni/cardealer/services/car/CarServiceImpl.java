package softuni.cardealer.services.car;

import org.modelmapper.ModelMapper;
import softuni.cardealer.model.dto.binding.CarSeedDto;
import softuni.cardealer.model.dto.view.CarMakerDto;
import softuni.cardealer.model.entity.Car;
import softuni.cardealer.model.entity.Part;
import softuni.cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.cardealer.repositories.PartRepository;

import java.util.*;

import static softuni.cardealer.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void saveWithRandomParts(Collection<CarSeedDto> carsSeedDto) {
        carsSeedDto.forEach(this::saveWithRandomParts);
    }

    @Override
    public void saveWithRandomParts(CarSeedDto carSeedDto) {

        Car car = modelMapper
                .map(carSeedDto, Car.class);

        int partsCount = this.partRepository
                .findAll().size();

        Set<Part> parts = new HashSet<>();

        Random random = new Random();

        long count = random.nextInt(20 - 10 + 1) + 10;

        for (long i = 10; i <= count; i++) {

            long partId = random.nextInt(partsCount) + 1;

            Part part = this.partRepository
                    .findByIdIs(partId);

            parts.add(part);
        }

        car.setParts(parts);

        this.carRepository
                .saveAndFlush(car);
    }

    @Override
    public List<CarMakerDto> getAllByMakerOrderByModelThenTravelledDistance(String maker) {

        List<Car> cars = this.carRepository
                .findAllByMakeOrderByModelAscTravelledDistanceDesc(maker);

        List<CarMakerDto> carsMakerDto = new ArrayList<>();

        for (Car car : cars) {

            CarMakerDto carMakerDto = modelMapper
                    .map(car, CarMakerDto.class);

            carsMakerDto.add(carMakerDto);
        }

        return carsMakerDto;
    }
}