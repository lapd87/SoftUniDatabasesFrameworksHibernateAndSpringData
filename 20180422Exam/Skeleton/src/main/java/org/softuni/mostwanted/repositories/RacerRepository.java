package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.dto.exportDtos.RacerCarsJSONExportDto;
import org.softuni.mostwanted.domain.dto.exportDtos.TownJSONExportDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.softuni.mostwanted.domain.models.Racer;

import java.util.List;

@Repository
public interface RacerRepository extends JpaRepository<Racer, Integer> {


    Racer findByName(String name);

    @Query(value = "SELECT new org.softuni.mostwanted.domain.dto.exportDtos.TownJSONExportDto(" +
            "t.name, count(r.id)) " +
            "from Racer as r " +
            "join r.homeTown as t " +
            "group by r.homeTown " +
            "having r.homeTown is not null " +
            "order by count(r.id) DESC , t.name")
    List<TownJSONExportDto> findRacingTowns();


}