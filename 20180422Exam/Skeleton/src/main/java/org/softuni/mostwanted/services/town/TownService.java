package org.softuni.mostwanted.services.town;

import org.softuni.mostwanted.domain.dto.importDtos.TownJSONImportDto;

public interface TownService {
    String create(TownJSONImportDto dto);
}