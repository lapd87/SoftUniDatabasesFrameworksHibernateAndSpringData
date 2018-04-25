package softuni._01bookshopsystem.services;

import softuni._01bookshopsystem.models.entity.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 31.3.2018 г.
 * Time: 13:33 ч.
 */
public interface CategoryService {

    void saveCategoryIntoDB(Category category);

    List<Category> getAllCategories();

}
