package softuni.productshop.services.product;

import org.modelmapper.ModelMapper;
import softuni.productshop.model.dto.binding.ProductSeedDto;
import softuni.productshop.model.dto.view.ProductInRangeDto;
import softuni.productshop.model.entity.Product;
import softuni.productshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static softuni.productshop.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductSeedDto productSeedDto) {

        Product product = modelMapper
                .map(productSeedDto, Product.class);

        this.productRepository
                .saveAndFlush(product);
    }

    @Override
    public void save(Collection<ProductSeedDto> productsSeedDto) {

        productsSeedDto.forEach(p->save(p));
    }

    @Override
    public Product getById(Long id) {

        return this.productRepository
                .findByIdIs(id);
    }

    @Override
    public List<ProductInRangeDto> getAllWithoutBuyerWithPriceRangeOrderByPriceAsc(BigDecimal minPrice, BigDecimal maxPrice) {

        List<Product> products = this.productRepository
                .findByBuyerIsNullAndPriceBetweenOrderByPriceAsc(minPrice, maxPrice);

        List<ProductInRangeDto> productsInRangeDto = new ArrayList<>();

        for (Product product : products) {

            productsInRangeDto
                    .add(modelMapper
                            .map(product, ProductInRangeDto.class));
        }

        return productsInRangeDto;
    }


}