package org.softuni.mostwanted.services.raceEntry;

import org.softuni.mostwanted.domain.dto.importDtos.RaceEntryXMLImportDto;

public interface RaceEntryService {
    String create(RaceEntryXMLImportDto dto);
}