package app.repositories;

import app.model.ingredients.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.ingredients.BasicIngredient;

import java.util.List;
import java.util.Set;

@Repository
public interface BasicIngredientRepository extends JpaRepository<BasicIngredient, Long> {

    List<BasicIngredient> findAllByNameStartingWith(String pattern);

    BasicIngredient findByName(String name);

    List<BasicIngredient> findAllByNameIn(List<String> names);

    @Modifying
    @Query("DELETE from BasicIngredient as bi " +
            "where bi.name = :ingredientName")
    void deleteIngredientsByName(@Param("ingredientName") String name);

    @Modifying
    @Query("UPDATE BasicIngredient " +
            "set price = price * 1.1")
    void updateIngredientPriceAddTenPercent();

    @Modifying
    @Query("UPDATE BasicIngredient " +
            "set price = price * 1.1 " +
            "where name in:listNames")
    void updateIngredientPriceByName(@Param("listNames") List<String> names);

}