package softuni.gamestore.model.dto.user;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 12:08 ч.
 */
public class UserExistsDto {

    private Long id;
    private String name;

    public UserExistsDto() {
    }

    public UserExistsDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}