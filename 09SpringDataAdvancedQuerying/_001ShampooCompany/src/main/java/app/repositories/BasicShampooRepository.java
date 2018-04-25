package app.repositories;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.model.labels.Label;
import app.model.shampoos.Shampoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.shampoos.BasicShampoo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface BasicShampooRepository extends JpaRepository<BasicShampoo, Long> {

    Set<BasicShampoo> findAllBySizeOrderById(Size size);

    Set<BasicShampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, long labelId);

    Set<BasicShampoo> findAllByPriceAfterOrderByPriceDesc(BigDecimal price);

    int countAllByPriceBefore(BigDecimal price);

    Set<BasicShampoo> findAllByIngredientsIn(List<BasicIngredient> ingredients);

    @Query("SELECT bs " +
            "from BasicShampoo as bs " +
            "where bs.ingredients.size < :ingredientsCount")
    Set<BasicShampoo> findByIngredientsCount(@Param("ingredientsCount") int maxCount);

    @Query("select sum(i.price) " +
            "from BasicShampoo as bs " +
            "join bs.ingredients as i " +
            "where bs.brand = :brandName")
    BigDecimal findIngredientsPriceByBrand(@Param("brandName")String brand);


}