package softuni.productshop2.services.product;

import softuni.productshop2.model.dto.binding.ProductSeedDto;
import softuni.productshop2.model.dto.view.ProductInRangeDto;
import softuni.productshop2.model.entity.Product;
import softuni.productshop2.model.entity.User;
import softuni.productshop2.model.validators.ValidationUtil;
import softuni.productshop2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.productshop2.repositories.UserRepository;
import softuni.productshop2.util.MapperUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void seedWithRandomSellerBuyer(List<ProductSeedDto> productSeedDtos) {

        List<Product> products = MapperUtil
                .convertToList(productSeedDtos, Product.class);

        for (Product product : products) {

            Random random = new Random();

            long buyerId = random
                    .nextInt((int) this.userRepository.count()) + 1;
            User buyer = this.userRepository
                    .getOne(buyerId);

            long sellerId = random
                    .nextInt((int) this.userRepository.count()) + 1;
            User seller = this.userRepository
                    .getOne(sellerId);

            product.setSeller(seller);

            if (buyerId % 3 != 0) {
                product.setBuyer(buyer);
            }
        }


        for (Product product : products) {

            if (ValidationUtil
                    .isValid(product)) {
                this.productRepository.save(product);
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public List<ProductInRangeDto> getByPriceRangeOrdered(BigDecimal min, BigDecimal max) {

        List<ProductInRangeDto> productsInRange = this.productRepository
                .findAllByPriceBetweenOrderByPrice(min, max);

        return productsInRange;
    }
}