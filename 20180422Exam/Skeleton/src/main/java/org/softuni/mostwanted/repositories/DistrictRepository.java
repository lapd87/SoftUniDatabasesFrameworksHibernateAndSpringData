package org.softuni.mostwanted.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.softuni.mostwanted.domain.models.District;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {


    District findByNameIs(String name);

    List<District> findByName(String name);
}