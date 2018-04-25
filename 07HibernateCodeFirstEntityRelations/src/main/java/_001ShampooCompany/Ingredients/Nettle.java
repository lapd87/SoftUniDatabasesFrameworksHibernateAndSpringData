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
@DiscriminatorValue(value = "NTL")
public class Nettle extends BasicIngredient {
    private static final String NAME = "Nettle";

    private static final BigDecimal PRICE = new BigDecimal("3.28");

    public Nettle() {
        super(NAME, PRICE);
    }
}