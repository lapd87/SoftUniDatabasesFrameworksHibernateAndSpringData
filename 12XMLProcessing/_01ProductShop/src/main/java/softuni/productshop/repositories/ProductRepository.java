package softuni.productshop.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.productshop.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdIs(Long id);

    List<Product> findByBuyerIsNullAndPriceBetweenOrderByPriceAsc(BigDecimal minPrice, BigDecimal maxPrice);

}