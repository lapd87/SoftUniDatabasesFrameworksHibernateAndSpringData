package _001ShampooCompany.Ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 18:37 ч.
 */

@Entity
@DiscriminatorValue(value = "ST")
public class Strawberry extends BasicIngredient {

private static final String NAME = "Strawberry";

private static final BigDecimal PRICE = new BigDecimal("4.85");

    public Strawberry() {
        super(NAME, PRICE);
    }
}