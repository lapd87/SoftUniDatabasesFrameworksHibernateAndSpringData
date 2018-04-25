package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 17:19 ч.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldDto {

    @XmlAttribute
    private String firstName;
    @XmlAttribute
    private String lastName;

    @XmlElementWrapper
    private Set<ProductSoldDto> soldProducts;

    public UserSoldDto() {
    }

    public UserSoldDto(String firstName,
                       String lastName,
                       Set<ProductSoldDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
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