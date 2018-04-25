package softuni.productshop2.model.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.4.2018 г.
 * Time: 17:23 ч.
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldWrapper {

    @XmlElement(name = "user")
    private List<UserSoldDto> userSoldDtoList;

    public UserSoldWrapper() {
    }

    public UserSoldWrapper(List<UserSoldDto> userSoldDtoList) {
        this.userSoldDtoList = userSoldDtoList;
    }

    public List<UserSoldDto> getUserSoldDtoList() {
        return userSoldDtoList;
    }

    public void setUserSoldDtoList(List<UserSoldDto> userSoldDtoList) {
        this.userSoldDtoList = userSoldDtoList;
    }
}