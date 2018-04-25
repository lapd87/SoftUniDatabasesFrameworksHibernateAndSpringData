package softuni.productshop.services.category;

import org.modelmapper.ModelMapper;
import softuni.productshop.model.dto.binding.CategorySeedDto;
import softuni.productshop.model.entity.Category;
import softuni.productshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static softuni.productshop.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private static final ModelMapper modelMapper= getMapper();

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(Long id) {
        return this.categoryRepository.findByIdIs(id);
    }

    @Override
    public void save(CategorySeedDto categorySeedDto) {

        Category category = modelMapper
                .map(categorySeedDto, Category.class);

        this.categoryRepository
                .saveAndFlush(category);
    }

    @Override
    public void save(Collection<CategorySeedDto> categoriesSeedDto) {

        categoriesSeedDto.forEach(this::save);
    }
}