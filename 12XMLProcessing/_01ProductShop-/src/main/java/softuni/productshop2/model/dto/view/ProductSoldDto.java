package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 17:13 ч.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldDto {

    @XmlElement
    private String name;
    @XmlElement
    private BigDecimal price;
    @XmlElement
    private String buyerFirstName;
    @XmlElement
    private String buyerLastName;

    public ProductSoldDto() {
    }

    public ProductSoldDto(String name,
                          BigDecimal price,
                          String buyerFirstName,
                          String buyerLastName) {
        this.name = name;
        this.price = price;
        this.buyerFirstName = buyerFirstName;
        this.buyerLastName = buyerLastName;
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

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }
}