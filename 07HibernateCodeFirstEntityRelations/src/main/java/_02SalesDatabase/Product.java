package _02SalesDatabase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 12:27 ч.
 */

@Entity
@Table(name = "product")
public class Product {

    private int id;
    private String name;
    private Double quantity;
    private BigDecimal price;
    private Set<Sale> sales;




    public Product() {
    }

    public Product(int id, String name, Double quantity,
                   BigDecimal price, Set<Sale> sales) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.sales = sales;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Basic
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "product")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}