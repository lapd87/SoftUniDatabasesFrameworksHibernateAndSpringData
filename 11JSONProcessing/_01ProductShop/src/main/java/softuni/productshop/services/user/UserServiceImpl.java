package softuni.productshop.services.user;

import org.modelmapper.ModelMapper;
import softuni.productshop.model.dto.binding.UserSeedDto;
import softuni.productshop.model.dto.view.ProductSoldDto;
import softuni.productshop.model.dto.view.UserSellerDto;
import softuni.productshop.model.entity.Product;
import softuni.productshop.model.entity.User;
import softuni.productshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static softuni.productshop.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserSeedDto userSeedDto) {

        User user = modelMapper
                .map(userSeedDto, User.class);

        this.userRepository
                .saveAndFlush(user);
    }

    @Override
    public void save(Collection<UserSeedDto> usersSeedDto) {

        usersSeedDto
                .forEach(this::save);
    }

    @Override
    public User getById(Long id) {

        return this.userRepository.findByIdIs(id);
    }

    @Override
    public Set<UserSeedDto> getAll() {

        List<User> users = this.userRepository
                .findAll();

        Set<UserSeedDto> usersSeedDto = new HashSet<>();

        for (User user : users) {
            usersSeedDto
                    .add(modelMapper
                            .map(user, UserSeedDto.class));
        }


        return usersSeedDto;
    }

    @Override
    public List<UserSellerDto> getAllSellersWithSoldProducts() {

        List<User> users = this.userRepository
                .findAllUsersWithSoldProducts();

        List<UserSellerDto> usersSellerDto = new ArrayList<>();

        for (User user : users) {

            UserSellerDto userSellerDto = new UserSellerDto();

            userSellerDto.setFirstName(user.getFirstName());
            userSellerDto.setLastName(user.getLastName());

            Set<ProductSoldDto> productsSoldDtos = new HashSet<>();

            for (Product product : user.getProductsForSale()) {

                if (product.getBuyer().getLastName() != null) {
                    productsSoldDtos
                            .add(modelMapper
                                    .map(product, ProductSoldDto.class));
                }
            }

            userSellerDto.setSoldProducts(productsSoldDtos);

            usersSellerDto.add(userSellerDto);
        }

        return usersSellerDto;
    }
}