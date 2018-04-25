package softuni.productshop.model.dto.binding;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 20:49 ч.
 */

@XmlRootElement(name = "users")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class UserSeedWrapper {

    @XmlElement(name = "user")
    private List<UserSeedDto> userSeedDtos;


    public List<UserSeedDto> getUserSeedDtos() {
        return userSeedDtos;
    }
}