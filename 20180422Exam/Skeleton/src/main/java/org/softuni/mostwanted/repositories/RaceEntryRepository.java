package org.softuni.mostwanted.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.softuni.mostwanted.domain.models.RaceEntry;

@Repository
public interface RaceEntryRepository extends JpaRepository<RaceEntry,Integer> {


}