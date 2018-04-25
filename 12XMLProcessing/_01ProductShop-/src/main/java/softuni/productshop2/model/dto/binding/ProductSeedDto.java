package softuni.productshop2.model.dto.binding;

import softuni.productshop2.model.entity.User;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 14:26 ч.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProductSeedDto {

    @XmlElement
    private String name;
    @XmlElement
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