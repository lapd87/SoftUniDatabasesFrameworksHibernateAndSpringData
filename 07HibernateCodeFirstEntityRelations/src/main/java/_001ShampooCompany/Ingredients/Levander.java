package _001ShampooCompany.Ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 18:34 ч.
 */

@Entity
@DiscriminatorValue(value = "LV")
public class Levander extends BasicIngredient {
    private static final String NAME = "Levander";

    private static final BigDecimal PRICE = new BigDecimal("0.88");

    public Levander() {
        super(NAME, PRICE);
    }
}