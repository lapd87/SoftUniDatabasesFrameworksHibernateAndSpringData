package softuni.cardealer.services.car;

import softuni.cardealer.model.dto.binding.CarSeedDto;
import softuni.cardealer.model.dto.view.CarMakerDto;
import softuni.cardealer.model.entity.Car;

import java.util.Collection;
import java.util.List;

public interface CarService {

    void saveWithRandomParts(Collection<CarSeedDto> carsSeedDto);

    void saveWithRandomParts(CarSeedDto carSeedDto);

    List<CarMakerDto> getAllByMakerOrderByModelThenTravelledDistance(String maker);
}