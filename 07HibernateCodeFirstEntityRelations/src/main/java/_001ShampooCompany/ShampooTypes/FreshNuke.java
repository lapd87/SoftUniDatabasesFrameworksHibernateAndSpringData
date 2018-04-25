package _001ShampooCompany.ShampooTypes;

import _001ShampooCompany.Shampoo.BasicLabel;
import _001ShampooCompany.Shampoo.BasicShampoo;
import _001ShampooCompany.Shampoo.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.3.2018 г.
 * Time: 20:46 ч.
 */

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    private static final String BRAND = "Fresh Nuke";

    private static final BigDecimal PRICE = new BigDecimal("9.33");

    private static final Size SIZE = Size.LARGE;

    public FreshNuke() {
    }

    public FreshNuke( BasicLabel label) {
        super(BRAND,PRICE,SIZE, label);
    }
}