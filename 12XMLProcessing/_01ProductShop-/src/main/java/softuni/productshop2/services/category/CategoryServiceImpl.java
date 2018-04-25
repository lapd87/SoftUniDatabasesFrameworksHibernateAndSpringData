package softuni.productshop2.services.category;

import softuni.productshop2.model.dto.binding.CategorySeedDto;
import softuni.productshop2.model.entity.Category;
import softuni.productshop2.model.entity.Product;
import softuni.productshop2.model.validators.ValidationUtil;
import softuni.productshop2.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.productshop2.repositories.ProductRepository;
import softuni.productshop2.util.MapperUtil;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedWithRandomProducts(List<CategorySeedDto> categorySeedDtos) {

        List<Category> categories = MapperUtil
                .convertToList(categorySeedDtos, Category.class);

        for (Category category : categories) {

            Random random = new Random();

            int productsCount = (random
                    .nextInt((int) this.productRepository.count()) + 1) / 10;

            Set<Product> products = category.getProducts();

            for (int i = 0; i < productsCount; i++) {

                long productId = random
                        .nextInt((int) this.productRepository.count()) + 1;

                Product product = this.productRepository
                        .getOne(productId);

                long count = this.productRepository.count();

                if (products.contains(product)) {
                    break;
                } else {
                    products.add(product);
                }
            }
            category.setProducts(products);
        }

        for (Category category : categories) {

            if (ValidationUtil
                    .isValid(category)) {
                this.categoryRepository.save(category);
                System.out.println(category.toString());
            }
        }
    }
}