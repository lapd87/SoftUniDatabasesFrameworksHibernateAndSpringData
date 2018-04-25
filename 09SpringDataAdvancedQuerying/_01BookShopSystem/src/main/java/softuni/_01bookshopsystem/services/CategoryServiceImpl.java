package softuni._01bookshopsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._01bookshopsystem.models.entity.Category;
import softuni._01bookshopsystem.repositories.AuthorRepository;
import softuni._01bookshopsystem.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:35 ч.
 */
@Service
@Transactional
public class CategoryServiceImpl
        implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void saveCategoryIntoDB(Category category) {
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

}