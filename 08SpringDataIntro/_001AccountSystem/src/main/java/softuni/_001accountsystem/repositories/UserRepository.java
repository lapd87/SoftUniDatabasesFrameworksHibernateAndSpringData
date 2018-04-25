package softuni._001accountsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softuni._001accountsystem.models.entities.User;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:48 ч.
 */

@Repository
public interface UserRepository
        extends CrudRepository<User, Long> {

    User getByUsername(String username);

    Set<User> getAllByAgeGreaterThan(int age);


}