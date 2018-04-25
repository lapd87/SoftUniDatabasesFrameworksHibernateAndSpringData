package app.services.basicIngredient;

import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;

import java.util.List;
import java.util.Set;

public interface BasicIngredientService {

    List<BasicIngredient> getAllByNameLike(String pattern);

    List<BasicIngredient> getAllByNameOrderByPrice(List<String> names);

    List<BasicIngredient> getAllByNameIn(List<String> names);

    void deleteIngredientByName(String name);

    void updateIngredientPriceAdd10Percent();

    void updateIngredientPriceByName(List<String> names);
}