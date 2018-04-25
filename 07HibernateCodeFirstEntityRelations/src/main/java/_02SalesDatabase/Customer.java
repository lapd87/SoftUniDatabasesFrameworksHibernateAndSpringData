package _02SalesDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 12:28 ч.
 */

@Entity
@Table(name = "customer")
public class Customer   {

    private int id;
    private String name;
    private String email;
    private String creditCardNumber;
    private Set<Sale> sales;



    public Customer() {
    }

    public Customer(int id, String name, String email,
                    String creditCardNumber, Set<Sale> sales) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "credit_card_number")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}