package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.models.Racer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.softuni.mostwanted.domain.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

Car findByBrandAndModelAndYearOfProductionAndRacer(String brand, String model, Integer yearOdProduction, Racer racer);
}