package softuni.gamestore.services.user;

import org.modelmapper.ModelMapper;
import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.dto.user.UserExistsDto;
import softuni.gamestore.model.dto.user.UserLoginDto;
import softuni.gamestore.model.dto.user.UserLogoutDto;
import softuni.gamestore.model.dto.user.UserRegisterDto;
import softuni.gamestore.model.entity.Game;
import softuni.gamestore.model.entity.User;
import softuni.gamestore.model.enums.Role;
import softuni.gamestore.repositories.GameRepository;
import softuni.gamestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

import static softuni.gamestore.ConsoleRunner.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           GameRepository gameRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getByEmail(String email) {
        return this.userRepository
                .findByEmailIs(email);
    }

    @Override
    public boolean registerUser(UserRegisterDto userRegisterDto) {

        User checkUser = getByEmail(userRegisterDto.getEmail());

        if (checkUser != null) {
            System.out.println(IODelimiter + "Duplicate user");
            return false;
        }

        boolean passwordMatch = userRegisterDto
                .getPassword()
                .equals(userRegisterDto
                        .getConfirmPassword());

        if (!passwordMatch) {
            System.out.println(IODelimiter + "Confirm password mismatch");
            return false;
        }

        User user = this.modelMapper
                .map(userRegisterDto, User.class);

        Role role = null;
        if (this.userRepository.count() == 0) {
            role = Role.ADMIN;
        } else {
            role = Role.USER;
        }

        user.setRole(role);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<User>> constraintViolations = validatorFactory.getValidator().validate(user);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<User> constraintViolation : constraintViolations) {
                System.out.println(IODelimiter + constraintViolation.getMessage());
            }

            return false;
        }

        this.userRepository
                .saveAndFlush(user);

        return true;
    }

    @Override
    public UserExistsDto loginUser(UserLoginDto userLoginDto) {

        User user = this.userRepository
                .findByEmailIs(userLoginDto.getEmail());

        boolean passwordMatch = false;

        if (user != null) {
            passwordMatch = userLoginDto.getPassword()
                    .equals(user.getPassword());
        }

        if (!passwordMatch) {
            System.out.println(IODelimiter + "Incorrect username / password");
            return null;
        }

        UserExistsDto userExistsDto = this.modelMapper
                .map(user, UserExistsDto.class);

        return userExistsDto;
    }

    @Override
    public UserExistsDto logoutUser(UserLogoutDto userLogoutDto) {

        User user = this.userRepository
                .findByEmailIs(userLogoutDto.getEmail());

        if (user == null) {
            System.out.println(IODelimiter + "Incorrect email");
            return null;
        }

        UserExistsDto userExistsDto = this.modelMapper
                .map(user, UserExistsDto.class);

        return userExistsDto;
    }

    @Override
    public boolean checkAdminById(Set<Long> usersId) {

        Set<User> usersById = this.userRepository
                .findByIdIn(usersId);


        boolean hasAdmin = false;

        for (User user : usersById) {
            Role role = user.getRole();
            if (role == Role.ADMIN) {
                hasAdmin = true;
                break;
            }
        }

        if (!hasAdmin)
            noAdmin();

        return hasAdmin;
    }

    @Override
    public Set<GameOwnedDto> getGamesOwnedDtoByUserId(Long id) {

        User user = this.userRepository
                .findByIdIs(id);

        if (user == null) {
            noSuchUser();
            return null;
        }

        Set<Game> gamesOwned = user.getOwnedGames();

        Set<GameOwnedDto> gameOwnedDtos = new HashSet<>();

        for (Game game : gamesOwned) {

            GameOwnedDto gameOwnedDto = this.modelMapper
                    .map(game, GameOwnedDto.class);

            gameOwnedDtos.add(gameOwnedDto);
        }

        return gameOwnedDtos;
    }

    @Override
    public Set<GameOwnedDto> getGamesShoppingCartByUserId(Long id) {
        User user = this.userRepository
                .findByIdIs(id);

        if (user == null) {
            noSuchUser();
            return null;
        }

        Set<Game> gamesShoppingCart = user.getShoppingCartGames();

        Set<GameOwnedDto> gamesShoppingCartDto = new HashSet<>();

        for (Game game : gamesShoppingCart) {

            GameOwnedDto gameShoppingCart = this.modelMapper
                    .map(game, GameOwnedDto.class);

            gamesShoppingCartDto.add(gameShoppingCart);
        }

        return gamesShoppingCartDto;
    }

    @Override
    public boolean addGameToShoppingCart(Long id, String title) {

        User user = this.userRepository
                .findByIdIs(id);

        if (user == null) {
            noSuchUser();
            return false;
        }

        Game game = this.gameRepository
                .findByTitleIs(title);

        if (game == null) {
            noSuchGame();
            return false;
        }

        Set<Game> shoppingCartGames = user.getShoppingCartGames();

        shoppingCartGames.add(game);

        this.userRepository.saveAndFlush(user);

        return true;
    }

    @Override
    public boolean removeGameFromShoppingCart(Long id, String title) {

        User user = this.userRepository
                .findByIdIs(id);

        if (user == null) {
            noSuchUser();
            return false;
        }

        Game game = this.gameRepository
                .findByTitleIs(title);

        if (game == null) {
            noSuchGame();
            return false;
        }

        Set<Game> shoppingCartGames = user.getShoppingCartGames();

        shoppingCartGames.remove(game);

        this.userRepository.saveAndFlush(user);

        return true;
    }

    @Override
    public boolean buyGamesFromShoppingCart(Long id) {

        User user = this.userRepository
                .findByIdIs(id);

        if (user == null) {
            noSuchUser();
            return false;
        }

        Set<Game> shoppingCartGames = user.getShoppingCartGames();
        Set<Game> ownedGames = user.getOwnedGames();

        for (Game game : shoppingCartGames) {

            ownedGames.add(game);
        }

        shoppingCartGames = new HashSet<>();

        user.setShoppingCartGames(shoppingCartGames);
        user.setOwnedGames(ownedGames);

        this.userRepository.saveAndFlush(user);

        return true;
    }
}