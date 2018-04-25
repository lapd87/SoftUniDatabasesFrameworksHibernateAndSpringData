package app.services.basicIngredient;

import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.repositories.BasicIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BasicIngredientServiceImpl implements BasicIngredientService {

    private final BasicIngredientRepository basicIngredientRepository;

    @Autowired
    public BasicIngredientServiceImpl(BasicIngredientRepository basicIngredientRepository) {
        this.basicIngredientRepository = basicIngredientRepository;
    }

    @Override
    public List<BasicIngredient> getAllByNameLike(String pattern) {
        return this.basicIngredientRepository
                .findAllByNameStartingWith(pattern);
    }

    @Override
    public List<BasicIngredient> getAllByNameOrderByPrice(List<String> names) {

        List<BasicIngredient> ingredients = new ArrayList<>();

        for (String name : names) {
            ingredients
                    .add(this.basicIngredientRepository
                            .findByName(name));
        }

        ingredients = ingredients
                .stream()
                .sorted(Comparator
                        .comparing(BasicIngredient::getPrice)
                        .thenComparing(BasicIngredient::getId))
                .collect(Collectors.toList());

        return ingredients;
    }

    @Override
    public List<BasicIngredient> getAllByNameIn(List<String> names) {
        return this.basicIngredientRepository
                .findAllByNameIn(names);
    }

    @Override
    public void deleteIngredientByName(String name) {
        this.basicIngredientRepository
                .deleteIngredientsByName(name);
    }

    @Override
    public void updateIngredientPriceAdd10Percent() {
        this.basicIngredientRepository
                .updateIngredientPriceAddTenPercent();
    }

    @Override
    public void updateIngredientPriceByName(List<String> names) {
        this.basicIngredientRepository
                .updateIngredientPriceByName(names);
    }
}