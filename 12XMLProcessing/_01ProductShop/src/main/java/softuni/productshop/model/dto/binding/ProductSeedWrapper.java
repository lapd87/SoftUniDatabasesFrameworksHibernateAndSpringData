package softuni.productshop.model.dto.binding;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 20:49 ч.
 */

@XmlRootElement(name = "products")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProductSeedWrapper {

    @XmlElement(name = "product")
    private List<ProductSeedDto> productSeedDtos;


    public List<ProductSeedDto> getProductSeedDtos() {
        return productSeedDtos;
    }
}