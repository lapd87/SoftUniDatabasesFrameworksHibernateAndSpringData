package softuni.productshop.model.dto.binding;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;
import softuni.productshop.model.entity.Category;
import softuni.productshop.model.entity.User;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.4.2018 г.
 * Time: 15:52 ч.
 */
public class ProductSeedDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    private User buyer;
    private User seller;


    public ProductSeedDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

}