package softuni._02usersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni._02usersystem.models.entity.Town;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:57 ч.
 */
@Repository
public interface TownRepo
        extends JpaRepository<Town, Long> {

    Town findById(Long id);

}