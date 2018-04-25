package softuni.productshop.model.dto.view;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 14:18 ч.
 */
public class UserSellerDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductSoldDto> productsForSale;

    public UserSellerDto() {
        this.productsForSale = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductSoldDto> getSoldProducts() {
        return productsForSale;
    }

    public void setSoldProducts(Set<ProductSoldDto> soldProducts) {
        this.productsForSale = soldProducts;
    }
}