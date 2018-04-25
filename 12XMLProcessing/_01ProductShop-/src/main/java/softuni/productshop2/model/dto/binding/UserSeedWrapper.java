package softuni.productshop2.model.dto.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 13:11 ч.
 */
@XmlRootElement(name = "users")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class UserSeedWrapper {

    @XmlElement(name = "user")
    private List<UserSeedDto> userSeedDtos;

    public UserSeedWrapper() {
        this.userSeedDtos = new ArrayList<>();
    }

    public List<UserSeedDto> getUserSeedDtos() {
        return userSeedDtos;
    }

    public void setUserSeedDtos(List<UserSeedDto> userSeedDtos) {
        this.userSeedDtos = userSeedDtos;
    }
}