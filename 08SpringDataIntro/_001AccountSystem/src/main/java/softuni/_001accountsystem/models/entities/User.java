package softuni._001accountsystem.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:38 ч.
 */

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String username;
    private int Age;
    private Set<Account> accounts;


    public User() {
        this.accounts = new HashSet<Account>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(columnDefinition = "INT(3)")
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @OneToMany(mappedBy = "user")
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}