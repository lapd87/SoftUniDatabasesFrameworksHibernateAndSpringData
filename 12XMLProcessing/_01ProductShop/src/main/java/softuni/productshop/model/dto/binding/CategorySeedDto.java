package softuni.productshop.model.dto.binding;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.4.2018 г.
 * Time: 16:31 ч.
 */

@XmlRootElement(name = "category")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CategorySeedDto {

    @Expose
    @XmlElement(name = "name")
    private String name;

    private Set<Product> products;


    public CategorySeedDto() {
        this.products = new HashSet<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}