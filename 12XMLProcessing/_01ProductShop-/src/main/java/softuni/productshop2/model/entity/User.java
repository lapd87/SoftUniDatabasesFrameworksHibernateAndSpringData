package softuni.productshop2.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static softuni.productshop2.ConsoleRunner.INPUT_ERROR_MSG;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 12:57 ч.
 */
@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    private Set<Product> productsSold;
    private Set<Product> productsBought;

    private Set<User> friends;


    public User() {
        this.productsSold = new HashSet<>();
        this.productsBought = new HashSet<>();
        this.friends = new HashSet<>();
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

    @Length(min = 3, message = INPUT_ERROR_MSG)
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "seller")
    public Set<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<Product> productsSold) {
        this.productsSold = productsSold;
    }

    @OneToMany(mappedBy = "buyer")
    public Set<Product> getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(Set<Product> productsBought) {
        this.productsBought = productsBought;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User - " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName;
    }
}