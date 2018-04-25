package softuni.productshop.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.4.2018 г.
 * Time: 16:08 ч.
 */
@Entity
@Table(name = "users")
public class User  {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    private Set<User> friends;

    private Set<Product> productsForSale;
    private Set<Product> productsToBuy;


    public User() {
        this.friends = new HashSet<>();
        this.productsForSale = new HashSet<>();
        this.productsToBuy = new HashSet<>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = 3, message = "Last name must be at least 3 symbols")
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(value = 0, message = "Age must be positive")
    @Max(value = 150, message = "Invalid user age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Product> getProductsForSale() {
        return productsForSale;
    }

    public void setProductsForSale(Set<Product> productsForSale) {
        this.productsForSale = productsForSale;
    }

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(Set<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }
}