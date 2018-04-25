package app.services.basicShampoo;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;
import app.repositories.BasicShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BasicShampooServiceImpl implements BasicShampooService {

    private final BasicShampooRepository basicShampooRepository;

    @Autowired
    public BasicShampooServiceImpl(BasicShampooRepository basicShampooRepository) {
        this.basicShampooRepository = basicShampooRepository;
    }

    @Override
    public Set<BasicShampoo> getBySizeOrderById(Size size) {
        return basicShampooRepository
                .findAllBySizeOrderById(size);
    }

    @Override
    public Set<BasicShampoo> getBySizeOrLabelIdOrderByPrice(Size size, long labelId) {
        return this.basicShampooRepository
                .findAllBySizeOrLabelIdOrderByPriceAsc(size,labelId);
    }

    @Override
    public Set<BasicShampoo> getByPriceAboveOrderByPriceDesc(BigDecimal price) {
        return this.basicShampooRepository
                .findAllByPriceAfterOrderByPriceDesc(price);
    }

    @Override
    public int getCountPriceBelow(BigDecimal price) {
        return this.basicShampooRepository
                .countAllByPriceBefore(price);
    }

    @Override
    public Set<BasicShampoo> getByIngredientsIn(List<BasicIngredient> ingredients) {
        return this.basicShampooRepository
                .findAllByIngredientsIn(ingredients);
    }

    @Override
    public Set<BasicShampoo> getByIngredientsCount(int maxCount) {
        return this.basicShampooRepository
                .findByIngredientsCount(maxCount);
    }

    @Override
    public BigDecimal getIngredientPriceByBrand(String brand) {
        return this.basicShampooRepository
                .findIngredientsPriceByBrand(brand);
    }
}