package softuni.productshop.model.dto.binding;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.4.2018 г.
 * Time: 16:31 ч.
 */
public class CategorySeedDto {

    @Expose
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