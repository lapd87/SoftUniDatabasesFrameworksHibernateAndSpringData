package _001ShampooCompany.Ingredients;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 18:14 ч.
 */
public interface ChemicalIngredient extends Ingredient {

    void setChemicalFormula(String chemicalFormula);

    String getChemicalFormula();
}