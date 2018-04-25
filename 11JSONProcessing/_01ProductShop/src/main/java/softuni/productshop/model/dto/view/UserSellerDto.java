package softuni.productshop.model.dto.view;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.Product;

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
    private Set<ProductSoldDto> soldProducts;

    public UserSellerDto() {
        this.soldProducts = new HashSet<>();
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
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}