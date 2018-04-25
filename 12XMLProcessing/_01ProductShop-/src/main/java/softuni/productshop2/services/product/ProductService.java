package softuni.productshop2.services.product;

import softuni.productshop2.model.dto.binding.ProductSeedDto;
import softuni.productshop2.model.dto.view.ProductInRangeDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedWithRandomSellerBuyer(List<ProductSeedDto> productSeedDtos);

    List<ProductInRangeDto> getByPriceRangeOrdered(BigDecimal min, BigDecimal max);
}