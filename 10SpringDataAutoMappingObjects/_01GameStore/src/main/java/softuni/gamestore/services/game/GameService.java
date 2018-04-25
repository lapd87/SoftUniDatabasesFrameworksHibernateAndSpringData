package softuni.gamestore.services.game;

import softuni.gamestore.model.dto.game.GameAddDto;
import softuni.gamestore.model.dto.game.GameDetailDto;
import softuni.gamestore.model.dto.game.GamePrintDto;
import softuni.gamestore.model.entity.Game;

import java.util.List;

public interface GameService {

    Game getByTitle(String title);

    boolean addGame(GameAddDto gameAddDto);

    Game getById(Long id);

    boolean editGame(String[] inputArgs);

    String getTitleById(Long id);

    boolean deleteGame(Long id);

    List<GamePrintDto> getAllPrintDto();

    GameDetailDto getByTitleDetailDto(String title);

}