package _001ShampooCompany.Ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.3.2018 г.
 * Time: 15:14 ч.
 */
@Entity
@DiscriminatorValue(value = "AMCL")
public class AmmoniumChloride extends BasicChemicalIngredient {

    private static final BigDecimal PRICE = new BigDecimal("6.12");

    private static final String NAME = "Ammonium Chloride";

    private static final String CHEMICAL_FORMULA = "NH4Cl";

    public AmmoniumChloride() {
        super(NAME, PRICE, CHEMICAL_FORMULA);
    }


}