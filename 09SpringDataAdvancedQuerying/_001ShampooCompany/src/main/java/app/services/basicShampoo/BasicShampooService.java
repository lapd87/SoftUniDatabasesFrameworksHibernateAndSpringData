package app.services.basicShampoo;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BasicShampooService {

    Set<BasicShampoo> getBySizeOrderById(Size size);

    Set<BasicShampoo> getBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    Set<BasicShampoo> getByPriceAboveOrderByPriceDesc(BigDecimal price);

    int getCountPriceBelow(BigDecimal price);

    Set<BasicShampoo> getByIngredientsIn(List<BasicIngredient> ingredients);

    Set<BasicShampoo> getByIngredientsCount(int maxCount);

    BigDecimal getIngredientPriceByBrand(String brand);
}