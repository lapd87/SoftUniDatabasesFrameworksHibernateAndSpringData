package softuni.productshop2.model.dto.binding;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 16:01 ч.
 */
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedWrapper {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categorySeedDtos;

    public CategorySeedWrapper() {
        this.categorySeedDtos = new ArrayList<>();
    }

    public List<CategorySeedDto> getCategorySeedDtos() {
        return categorySeedDtos;
    }

    public void setCategorySeedDtos(List<CategorySeedDto> categorySeedDtos) {
        this.categorySeedDtos = categorySeedDtos;
    }
}