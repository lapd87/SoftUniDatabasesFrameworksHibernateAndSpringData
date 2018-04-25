package org.softuni.mostwanted.services.race;

import org.softuni.mostwanted.domain.dto.importDtos.RaceXMLImportDto;

public interface RaceService {
    String create(RaceXMLImportDto dto);
}