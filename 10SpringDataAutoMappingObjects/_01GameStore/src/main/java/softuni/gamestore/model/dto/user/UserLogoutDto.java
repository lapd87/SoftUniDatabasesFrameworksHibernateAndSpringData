package softuni.gamestore.model.dto.user;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 11:54 ч.
 */
public class UserLogoutDto {

    private String email;

    public UserLogoutDto() {
    }

    public UserLogoutDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}