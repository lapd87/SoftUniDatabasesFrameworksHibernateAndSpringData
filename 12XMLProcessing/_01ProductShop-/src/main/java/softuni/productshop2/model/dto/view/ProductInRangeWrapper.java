package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 16:44 ч.
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeWrapper {

    @XmlElement(name = "product")
    private List<ProductInRangeDto> productInRangeDtoList;

    public ProductInRangeWrapper() {
        this.productInRangeDtoList = new ArrayList<>();
    }

    public ProductInRangeWrapper(List<ProductInRangeDto> productInRangeDtoList) {
        this.productInRangeDtoList = productInRangeDtoList;
    }

    public List<ProductInRangeDto> getProductInRangeDtoList() {
        return productInRangeDtoList;
    }

    public void setProductInRangeDtoList(List<ProductInRangeDto> productInRangeDtoList) {
        this.productInRangeDtoList = productInRangeDtoList;
    }
}