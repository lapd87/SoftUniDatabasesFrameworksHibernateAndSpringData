package softuni.productshop2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.productshop2.model.dto.view.ProductInRangeDto;
import softuni.productshop2.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new softuni.productshop2.model.dto.view.ProductInRangeDto(" +
            "p.name,p.price,concat(s.firstName, ' ', s.lastName)) " +
            "from Product as p inner join p.seller as s " +
            "where p.price between :min and :max " +
            "order by p.price")
    List<ProductInRangeDto> findAllByPriceBetweenOrderByPrice(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
}