package softuni.productshop.model.dto.view;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.User;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.4.2018 г.
 * Time: 13:06 ч.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProductInRangeDto {

    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlAttribute(name = "price")
    private String price;
    @Expose
    @XmlAttribute(name = "seller")
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