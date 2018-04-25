package _001ShampooCompany.Shampoo;


import _001ShampooCompany.Ingredients.BasicIngredient;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 17:54 ч.
 */

public interface Shampoo {
    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    BasicLabel getLabel();

    void setLabel(BasicLabel label);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
}
