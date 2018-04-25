package softuni.productshop.services.user;

import softuni.productshop.model.dto.binding.UserSeedDto;
import softuni.productshop.model.dto.view.UserSellerDto;
import softuni.productshop.model.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserService {

    void save(UserSeedDto userSeedDto);

    void save(Collection<UserSeedDto> usersSeedDto);

    User getById(Long id);

    Set<UserSeedDto> getAll();

    List<UserSellerDto> getAllSellersWithSoldProducts();
}