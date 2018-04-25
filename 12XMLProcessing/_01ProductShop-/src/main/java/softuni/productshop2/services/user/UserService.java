package softuni.productshop2.services.user;

import softuni.productshop2.model.dto.binding.UserSeedDto;
import softuni.productshop2.model.dto.binding.UserSeedWrapper;
import softuni.productshop2.model.dto.view.UserSoldDto;

import java.util.List;

public interface UserService {

    void seedWithRandomFriends(List<UserSeedDto> userSeedDtos);

    List<UserSoldDto> getUserWithSoldProductsOrdered();
}