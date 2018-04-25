package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.dto.exportDtos.TownJSONExportDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.softuni.mostwanted.domain.models.Town;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town,Integer> {


    Town findByName(String name);

}