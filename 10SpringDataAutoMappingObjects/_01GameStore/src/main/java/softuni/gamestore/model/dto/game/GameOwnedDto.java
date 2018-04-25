package softuni.gamestore.model.dto.game;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 16:08 ч.
 */
public class GameOwnedDto {

    private String title;

    public GameOwnedDto(String title) {
        this.title = title;
    }

    public GameOwnedDto() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}