package softuni.productshop.model.dto.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 21:23 ч.
 */
@XmlRootElement(name = "categories")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CategorySeedWrapper {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categorySeedDtos;


    public List<CategorySeedDto> getCategorySeedDtos() {
        return categorySeedDtos;
    }
}