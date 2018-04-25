package org.softuni.mostwanted.services.car;

import org.softuni.mostwanted.domain.dto.importDtos.CarJSONImportDto;

public interface CarService {
    String create(CarJSONImportDto dto);
}