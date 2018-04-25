package _05BillsPaymentSystem;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 19:34 ч.
 */

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BillingDetail> billingDetails;


    public User() {
    }

    public User(int id, String firstName, String lastName,
                String email, String password,
                Set<BillingDetail> billingDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.billingDetails = billingDetails;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "number",
            targetEntity = BillingDetail.class)
    public Set<BillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
    }
}