package softuni.gamestore.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.dto.game.GamePrintDto;
import softuni.gamestore.model.entity.Game;
import softuni.gamestore.model.entity.User;

import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    Game findByTitleIs(String title);

    Game findByIdIs(Long id);

}