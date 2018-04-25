package _001ShampooCompany.Ingredients;

import _001ShampooCompany.Shampoo.BasicShampoo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 17:57 ч.
 */
public interface Ingredient extends Serializable {

    String getName();

    void setName(String name);

    int getId();

    void setId(int id);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    List<BasicShampoo> getShampoos();

    void setShampoos(BasicShampoo shampoos);
}
