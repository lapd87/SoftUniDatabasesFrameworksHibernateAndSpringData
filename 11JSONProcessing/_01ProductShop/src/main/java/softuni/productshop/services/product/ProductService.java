package softuni.productshop.services.product;

import softuni.productshop.model.dto.binding.ProductSeedDto;
import softuni.productshop.model.dto.view.ProductInRangeDto;
import softuni.productshop.model.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ProductService {

    void save(ProductSeedDto productSeedDto);

    void save(Collection<ProductSeedDto> productsSeedDto);

    Product getById(Long id);

    List<ProductInRangeDto> getAllWithoutBuyerWithPriceRangeOrderByPriceAsc(BigDecimal minPrice, BigDecimal maxPrice);

}