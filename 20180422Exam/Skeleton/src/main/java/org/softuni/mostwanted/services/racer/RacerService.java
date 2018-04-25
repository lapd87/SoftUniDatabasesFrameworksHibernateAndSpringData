package org.softuni.mostwanted.services.racer;

import org.softuni.mostwanted.domain.dto.exportDtos.RacerCarsJSONExportDto;
import org.softuni.mostwanted.domain.dto.exportDtos.TownJSONExportDto;
import org.softuni.mostwanted.domain.dto.importDtos.RacerJSONImportDto;

import java.util.List;

public interface RacerService {
    String create(RacerJSONImportDto dto);

    List<TownJSONExportDto> getRacingTowns();

    List<RacerCarsJSONExportDto>  getAllRacersCars();


}