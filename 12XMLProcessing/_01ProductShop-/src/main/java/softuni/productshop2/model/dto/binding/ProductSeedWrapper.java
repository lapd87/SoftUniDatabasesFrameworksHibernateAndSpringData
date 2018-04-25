package softuni.productshop2.model.dto.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 14:26 ч.
 */
@XmlRootElement(name = "products")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProductSeedWrapper {

    @XmlElement(name = "product")
    private List<ProductSeedDto> productSeedDtos;

    public ProductSeedWrapper() {
        this.productSeedDtos = new ArrayList<>();
    }

    public List<ProductSeedDto> getProductSeedDtos() {
        return productSeedDtos;
    }

    public void setProductSeedDtos(List<ProductSeedDto> productSeedDtos) {
        this.productSeedDtos = productSeedDtos;
    }
}