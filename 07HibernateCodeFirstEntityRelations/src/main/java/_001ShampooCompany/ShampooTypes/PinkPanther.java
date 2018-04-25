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
 * Time: 20:50 ч.
 */

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {

    private static final String BRAND = "Pink Panther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");

    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther() {
    }

    public PinkPanther( BasicLabel label) {
        super(BRAND,PRICE,SIZE, label);
    }

}