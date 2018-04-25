package softuni.gamestore.model.entity;


import softuni.gamestore.model.enums.Role;
import softuni.gamestore.model.validators.Email;
import softuni.gamestore.model.validators.Password;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 16:17 ч.
 */
@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Set<Game> ownedGames;
    private Role role;
    private Set<Game> shoppingCartGames;


    public User() {
        this.ownedGames = new HashSet<>();
        this.shoppingCartGames = new HashSet<>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Email
    @Column(nullable = false, length = 50, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Password
    @Column(nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name", nullable = false, length = 100)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToMany
    public Set<Game> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(Set<Game> ownedGames) {
        this.ownedGames = ownedGames;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    public Set<Game> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }
}