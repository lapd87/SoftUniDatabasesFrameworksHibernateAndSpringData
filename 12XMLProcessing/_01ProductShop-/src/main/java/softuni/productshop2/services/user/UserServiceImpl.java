package softuni.productshop2.services.user;

import org.modelmapper.ModelMapper;
import softuni.productshop2.model.dto.binding.UserSeedDto;
import softuni.productshop2.model.dto.view.ProductSoldDto;
import softuni.productshop2.model.dto.view.UserSoldDto;
import softuni.productshop2.model.entity.Product;
import softuni.productshop2.model.entity.User;
import softuni.productshop2.model.validators.ValidationUtil;
import softuni.productshop2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.productshop2.util.MapperUtil;

import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
    }

    @Override
    public void seedWithRandomFriends(List<UserSeedDto> userSeedDtos) {

        List<User> users = MapperUtil
                .convertToList(userSeedDtos, User.class);

        this.userRepository.saveAll(users);

        for (User user : users) {

            Random random = new Random();

            int friendsCount = random.nextInt(users.size()) / 10;

            Set<User> friends = user.getFriends();

            for (int i = 0; i < friendsCount; i++) {

                long friendId = random.nextInt(users.size()) + 1;

                User friend = this.userRepository
                        .getOne(friendId);

                if (friends.contains(friend)) {
                    break;
                } else {
                    friends.add(friend);
                }
            }

            user.setFriends(friends);
        }

        for (User user : users) {

            if (ValidationUtil
                    .isValid(user)) {
                this.userRepository.save(user);
                System.out.println(user.toString());
            }
        }
    }

    @Override
    public List<UserSoldDto> getUserWithSoldProductsOrdered() {

        List<User> users = this.userRepository
                .findByUserWithSoldProductsOrdered();

        List<UserSoldDto> userSoldDtos = new ArrayList<>();


        for (User user : users) {

            UserSoldDto userSoldDto = new UserSoldDto();

            userSoldDto.setFirstName(user.getFirstName());
            userSoldDto.setLastName(user.getLastName());

            Set<Product> soldProducts = user.getProductsSold();

            Set<ProductSoldDto> productSoldDtos = new HashSet<>();

            for (Product soldProduct : soldProducts) {

                ProductSoldDto productSoldDto = new ProductSoldDto();

                productSoldDto.setName(soldProduct.getName());
                productSoldDto.setPrice(soldProduct.getPrice());
                productSoldDto.setBuyerFirstName(soldProduct.getBuyer().getFirstName());
                productSoldDto.setBuyerLastName(soldProduct.getBuyer().getLastName());

                productSoldDtos.add(productSoldDto);
            }

            userSoldDto.setSoldProducts(productSoldDtos);

            userSoldDtos.add(userSoldDto);
        }

        return userSoldDtos;
    }
}