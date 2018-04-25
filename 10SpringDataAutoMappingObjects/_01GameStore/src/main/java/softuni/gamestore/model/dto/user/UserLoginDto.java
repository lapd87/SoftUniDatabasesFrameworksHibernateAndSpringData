package softuni.gamestore.model.dto.user;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 11:11 ч.
 */
public class UserLoginDto {

    private String email;
    private String password;

    public UserLoginDto() {
    }


    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}