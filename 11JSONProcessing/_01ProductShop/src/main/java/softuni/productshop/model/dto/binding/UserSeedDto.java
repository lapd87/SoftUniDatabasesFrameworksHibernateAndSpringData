package softuni.productshop.model.dto.binding;

import com.google.gson.annotations.Expose;
import softuni.productshop.model.entity.User;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.4.2018 г.
 * Time: 11:58 ч.
 */
public class UserSeedDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    private Set<User> friends;


    public UserSeedDto() {
        this.friends = new HashSet<>();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}