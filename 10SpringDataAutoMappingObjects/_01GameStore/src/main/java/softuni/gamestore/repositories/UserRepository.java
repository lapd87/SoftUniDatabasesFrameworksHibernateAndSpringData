package softuni.gamestore.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.entity.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIs(String email);

    Set<User> findByIdIn(Set<Long> usersId);

    User findByIdIs(Long id);
}