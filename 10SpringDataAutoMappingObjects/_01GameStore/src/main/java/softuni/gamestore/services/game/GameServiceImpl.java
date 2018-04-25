package softuni.gamestore.services.game;

import org.modelmapper.ModelMapper;
import softuni.gamestore.model.dto.game.GameAddDto;
import softuni.gamestore.model.dto.game.GameDetailDto;
import softuni.gamestore.model.dto.game.GamePrintDto;
import softuni.gamestore.model.entity.Game;
import softuni.gamestore.model.entity.User;
import softuni.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static softuni.gamestore.ConsoleRunner.*;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository,
                           ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Game getByTitle(String title) {
        return this.gameRepository
                .findByTitleIs(title);
    }

    @Override
    public boolean addGame(GameAddDto gameAddDto) {

        Game checkGame = getByTitle(gameAddDto.getTitle());

        if (checkGame != null) {
            System.out.println(IODelimiter + "Game already exists");
            return false;
        }

        Game game = this.modelMapper
                .map(gameAddDto, Game.class);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Game>> constraintViolations = validatorFactory.getValidator().validate(game);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Game> constraintViolation : constraintViolations) {
                System.out.println(IODelimiter + constraintViolation.getMessage());
            }

            return false;
        }

        this.gameRepository.saveAndFlush(game);

        return true;
    }

    @Override
    public Game getById(Long id) {
        return this.gameRepository
                .findByIdIs(id);
    }

    @Override
    public boolean editGame(String[] inputArgs) {

        Long id = Long.parseLong(inputArgs[1]);

        Game game = getById(id);

        if (game == null) {
            noSuchGame();
            return false;
        }

        for (int i = 2; i < inputArgs.length; i++) {
            String[] editArgs = inputArgs[i]
                    .split("=", 2);

            String editCommand = editArgs[0];
            String editValue = editArgs[1];

            switch (editCommand) {
                case "title":
                    game.setTitle(editValue);
                    break;
                case "price":
                    game.setPrice(BigDecimal
                            .valueOf(Double
                                    .parseDouble(editValue)));
                    break;
                case "size":
                    game.setSize(Double
                            .parseDouble(editValue));
                    break;
                case "trailer":
                    String[] trailerInput = editValue.split("=",2);

                    String trailer = trailerInput[0];
                    if (trailerInput.length > 1) {
                        trailer = trailerInput[1];
                    }

                    game.setTrailer(trailer);
                    break;
                case "thumbnailURL":
                    game.setThumbnailURL(editValue);
                    break;
                case "description":
                    game.setDescription(editValue);
                    break;
                case "releaseDate":
                    Date date = parseDate(editValue);
                    game.setReleaseDate(date);
                    break;
                default:
                    invalidInput();
            }
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Game>> constraintViolations = validatorFactory.getValidator().validate(game);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<Game> constraintViolation : constraintViolations) {
                System.out.println(IODelimiter + constraintViolation.getMessage());
            }

            return false;
        }

        this.gameRepository.saveAndFlush(game);

        return true;
    }

    @Override
    public String getTitleById(Long id) {
        Game game = getById(id);

        if (game == null) {
            return null;
        }

        return game.getTitle();
    }

    @Override
    public boolean deleteGame(Long id) {

        Game game = this.gameRepository
                .findByIdIs(id);

        if (game == null) {
            noSuchGame();
            return false;
        }

        this.gameRepository.delete(game);
        return true;
    }

    @Override
    public List<GamePrintDto> getAllPrintDto() {

        List<Game> allGames = this.gameRepository
                .findAll();

        List<GamePrintDto> allGamesPrintDto = new ArrayList<>();

        for (Game game : allGames) {

            GamePrintDto gamePrintDto = this.modelMapper
                    .map(game, GamePrintDto.class);

            allGamesPrintDto.add(gamePrintDto);
        }

        return allGamesPrintDto;
    }

    @Override
    public GameDetailDto getByTitleDetailDto(String title) {

        Game game = getByTitle(title);

        if (game == null) {
            noSuchGame();
            return null;
        }

        GameDetailDto gameDetailDto = this.modelMapper
                .map(game, GameDetailDto.class);

        return gameDetailDto;
    }
}