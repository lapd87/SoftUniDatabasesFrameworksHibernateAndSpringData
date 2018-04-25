package softuni._02usersystem.services;

import softuni._02usersystem.models.entity.User;

import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:59 ч.
 */
public interface UserService {

    void registerUser(User user);

    Set<User> getByEmailHost(String host);

    Set<User> getByLastLogBefore(Date date);

    Set<User> getByIsDeleted(boolean isDeleted);

    void deleteUser(User user);
}
