package softuni.productshop.model.dto.view;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 21:36 ч.
 */
@XmlRootElement(name = "products")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProductInRangeWrapper {

    @XmlElement(name = "product")
    private List<ProductInRangeDto> productInRangeDtos;

    public ProductInRangeWrapper() {
    }

    public void setProductInRangeDtos(List<ProductInRangeDto> productInRangeDtos) {
        this.productInRangeDtos = productInRangeDtos;
    }
}