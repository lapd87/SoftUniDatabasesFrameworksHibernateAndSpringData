package _001ShampooCompany.Ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.3.2018 г.
 * Time: 15:09 ч.
 */
@Entity
public abstract class BasicChemicalIngredient
        extends BasicIngredient implements ChemicalIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    protected BasicChemicalIngredient() {
    }

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String getChemicalFormula() {
        return chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}