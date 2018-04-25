package softuni.productshop2.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static softuni.productshop2.ConsoleRunner.INPUT_ERROR_MSG;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 12:59 ч.
 */
@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private User buyer;
    private User seller;

    private Set<Category> categories;

    public Product() {
        this.categories = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Length(min = 3, message = INPUT_ERROR_MSG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = INPUT_ERROR_MSG)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @NotNull(message = INPUT_ERROR_MSG)
    @ManyToOne
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @ManyToMany(mappedBy = "products")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product - " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}