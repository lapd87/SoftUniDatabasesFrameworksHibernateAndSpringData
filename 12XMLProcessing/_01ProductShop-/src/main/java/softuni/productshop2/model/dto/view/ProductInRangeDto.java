package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 16:32 ч.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlAttribute
    private String seller;

    public ProductInRangeDto() {
    }


    public ProductInRangeDto(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
        this.seller = seller;
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
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}