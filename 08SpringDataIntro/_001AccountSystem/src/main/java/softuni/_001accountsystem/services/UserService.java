package softuni._001accountsystem.services;


import softuni._001accountsystem.models.entities.User;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:56 ч.
 */
public interface UserService {

    void registerUser(User user);

    User getUserByUsername(String username);
}
