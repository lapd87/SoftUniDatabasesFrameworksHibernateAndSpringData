package softuni.cardealer.model.dto.binding;

import com.google.gson.annotations.Expose;
import softuni.cardealer.model.entity.Supplier;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 20:26 ч.
 */
public class PartSeedDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private Integer quantity;

    public PartSeedDto() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}