package softuni._02usersystem.models.entity;

import softuni._02usersystem.models.validators.Email;
import softuni._02usersystem.models.validators.Password;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 11:36 ч.
 */

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private byte[] profilePicture;
    private Date userRegistration;
    private Date userLastLog;
    private int age;
    private boolean isDeleted;
    private Town bornTown;
    private Town currentTown;
    private String firstName;
    private String lastName;
    private String fullName;
    private Set<User> friends;
    private Set<Album> albums;


    public User() {
        this.friends = new HashSet<>();
        this.albums = new HashSet<>();
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    @Password(containsDigit = true,
            containsLowercase = true,
            containsUppercase = true,
            containsSpecialSymbols = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(max = 1000000)
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Column(name = "registerd_on", nullable = false)
    public Date getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(Date userRegistration) {
        this.userRegistration = userRegistration;
    }

    @Column(name = "last_time_logged_in", nullable = false)
    public Date getUserLastLog() {
        return userLastLog;
    }

    public void setUserLastLog(Date userLastLog) {
        this.userLastLog = userLastLog;
    }

    @Min(1)
    @Max(120)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "is_deleted", nullable = false,
            columnDefinition = "BOOL default 0")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne(optional = false)
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne(optional = false)
    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentTown) {
        this.currentTown = currentTown;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void setFullName(String fullName) {
        this.fullName = getFirstName() + " " + getLastName();
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "user")
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}