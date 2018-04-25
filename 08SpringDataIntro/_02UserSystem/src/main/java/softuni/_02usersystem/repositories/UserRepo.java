package softuni._02usersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni._02usersystem.models.entity.User;

import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:57 ч.
 */
@Repository
public interface UserRepo
        extends JpaRepository<User, Long> {

    Set<User> findByEmailEndingWith(String host);

    Set<User> findByUserLastLogBefore(Date date);

    Set<User> findByDeleted(boolean isDeleted);

}
