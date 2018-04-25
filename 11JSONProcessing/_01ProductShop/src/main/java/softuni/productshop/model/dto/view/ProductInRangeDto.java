package softuni.productshop.model.dto.view;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.User;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.4.2018 г.
 * Time: 13:06 ч.
 */
public class ProductInRangeDto {

    @Expose
    private String name;
    @Expose
    private String price;
    @Expose
    private String seller;

    public ProductInRangeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}