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
@DiscriminatorValue(value = "MNT")
public class Mint extends BasicIngredient {
    private static final String NAME = "Mint";

    private static final BigDecimal PRICE = new BigDecimal("2.43");

    public Mint() {
        super(NAME, PRICE);
    }
}