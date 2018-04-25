package softuni.productshop2.services.category;

import softuni.productshop2.model.dto.binding.CategorySeedDto;

import java.util.List;

public interface CategoryService {
    void seedWithRandomProducts(List<CategorySeedDto> categorySeedDtos);
}