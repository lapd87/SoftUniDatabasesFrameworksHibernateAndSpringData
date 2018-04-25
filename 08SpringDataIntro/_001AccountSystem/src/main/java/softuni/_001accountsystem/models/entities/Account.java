package softuni._001accountsystem.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:40 ч.
 */

@Entity
@Table(name = "accounts")
public class Account {

    private Long id;
    private BigDecimal balance;
    private User user;

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}