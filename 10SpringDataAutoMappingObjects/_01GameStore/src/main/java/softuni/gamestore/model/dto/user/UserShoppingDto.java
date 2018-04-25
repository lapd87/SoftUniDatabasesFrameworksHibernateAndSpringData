package softuni.gamestore.model.dto.user;

import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.entity.Game;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 19:55 ч.
 */
public class UserShoppingDto {

    private Set<GameOwnedDto> ownedGames;
    private Set<GameOwnedDto> shoppingCartGames;

    public UserShoppingDto() {
    }

    public UserShoppingDto(Set<GameOwnedDto> ownedGames,
                           Set<GameOwnedDto> shoppingCartGames) {
        this.ownedGames = ownedGames;
        this.shoppingCartGames = shoppingCartGames;
    }

    public Set<GameOwnedDto> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(Set<GameOwnedDto> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public Set<GameOwnedDto> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<GameOwnedDto> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }
}