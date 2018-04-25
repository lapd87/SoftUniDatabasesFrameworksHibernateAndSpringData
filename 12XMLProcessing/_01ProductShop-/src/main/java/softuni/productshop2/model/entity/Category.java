package softuni.productshop2.model.entity;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static softuni.productshop2.ConsoleRunner.INPUT_ERROR_MSG;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 14:45 ч.
 */
@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;

    private Set<Product> products;

    public Category() {
        this.products = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Length(min = 3, max = 15, message = INPUT_ERROR_MSG)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category - " +
                "id=" + id +
                ", name='" + name;
    }
}