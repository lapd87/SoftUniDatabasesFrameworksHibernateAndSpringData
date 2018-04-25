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
 * Time: 20:51 ч.
 */

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {

    private static final String BRAND = "Fifty Shades";

    private static final BigDecimal PRICE = new BigDecimal("6.69");

    private static final Size SIZE = Size.SMALL;

    public FiftyShades() {
    }

    public FiftyShades( BasicLabel label) {
        super(BRAND,PRICE,SIZE, label);
    }

}