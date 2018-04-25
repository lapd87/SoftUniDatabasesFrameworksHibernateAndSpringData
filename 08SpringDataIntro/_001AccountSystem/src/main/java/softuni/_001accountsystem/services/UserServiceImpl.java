package softuni._001accountsystem.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import softuni._001accountsystem.models.entities.User;
import softuni._001accountsystem.repositories.UserRepository;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:58 ч.
 */
@Service
@Primary
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User checkUser = this.userRepository.getByUsername(user.getUsername());
        if (checkUser == null) {
            this.userRepository.save(user);
        } else {
            User updatedUser = this.userRepository.getByUsername(user.getUsername());
            updatedUser.getAccounts().addAll(user.getAccounts());
            updatedUser.setAge(user.getAge());

            this.userRepository.save(updatedUser);
        }
    }


    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getByUsername(username);
    }
}


