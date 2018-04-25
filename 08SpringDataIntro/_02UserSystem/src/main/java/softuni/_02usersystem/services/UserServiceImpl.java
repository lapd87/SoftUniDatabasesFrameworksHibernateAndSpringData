package softuni._02usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni._02usersystem.models.entity.User;
import softuni._02usersystem.repositories.UserRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 13:04 ч.
 */
@Service
@Transactional
public class UserServiceImpl
        implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void registerUser(User user) {
        this.userRepo.saveAndFlush(user);
    }

    @Override
    public Set<User> getByEmailHost(String host) {
        return this.userRepo.findByEmailEndingWith(host);
    }

    @Override
    public Set<User> getByLastLogBefore(Date date) {
        return this.userRepo.findByUserLastLogBefore(date);
    }

    @Override
    public Set<User> getByIsDeleted(boolean isDeleted) {
        return this.userRepo.findByDeleted(isDeleted);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepo.delete(user);
    }
}