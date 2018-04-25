package softuni.gamestore.services.user;

import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.dto.user.UserExistsDto;
import softuni.gamestore.model.dto.user.UserLoginDto;
import softuni.gamestore.model.dto.user.UserLogoutDto;
import softuni.gamestore.model.dto.user.UserRegisterDto;
import softuni.gamestore.model.entity.Game;
import softuni.gamestore.model.entity.User;

import java.util.Set;

public interface UserService {

    User getByEmail(String email);

    boolean registerUser(UserRegisterDto userRegisterDto);

    UserExistsDto loginUser(UserLoginDto userLoginDto);

    UserExistsDto logoutUser(UserLogoutDto userLogoutDto);

    boolean checkAdminById(Set<Long> usersId);

    Set<GameOwnedDto> getGamesOwnedDtoByUserId(Long id);

    Set<GameOwnedDto> getGamesShoppingCartByUserId(Long id);

    boolean addGameToShoppingCart(Long id, String title);

    boolean removeGameFromShoppingCart(Long id, String title);

    boolean buyGamesFromShoppingCart(Long id);

}