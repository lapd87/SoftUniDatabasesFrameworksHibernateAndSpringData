package softuni.productshop.services.category;

import softuni.productshop.model.dto.binding.CategorySeedDto;
import softuni.productshop.model.entity.Category;

import java.util.Collection;

public interface CategoryService {

    Category getById(Long id);

    void save(CategorySeedDto categorySeedDto);

    void save(Collection<CategorySeedDto> categoriesSeedDto);}