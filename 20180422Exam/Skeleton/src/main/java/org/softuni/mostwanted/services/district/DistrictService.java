package org.softuni.mostwanted.services.district;

import org.softuni.mostwanted.domain.dto.importDtos.DistrictJSONImportDto;

public interface DistrictService {
    String create(DistrictJSONImportDto dto);
}