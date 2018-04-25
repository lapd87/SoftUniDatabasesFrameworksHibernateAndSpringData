package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 17:16 ч.
 */
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldWrapper {

    @XmlElement(name = "product")
    private Set<ProductSoldDto> productSoldDtoList;


    public ProductSoldWrapper() {
        this.productSoldDtoList=new HashSet<>();
    }

    public ProductSoldWrapper(Set<ProductSoldDto> productSoldDtoList) {
        this.productSoldDtoList = productSoldDtoList;
    }

    public Set<ProductSoldDto> getProductSoldDtoList() {
        return productSoldDtoList;
    }

    public void setProductSoldDtoList(Set<ProductSoldDto> productSoldDtoList) {
        this.productSoldDtoList = productSoldDtoList;
    }
}