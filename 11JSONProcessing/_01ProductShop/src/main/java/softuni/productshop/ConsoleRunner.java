package softuni.productshop;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import softuni.productshop.model.dto.binding.CategorySeedDto;
import softuni.productshop.model.dto.binding.ProductSeedDto;
import softuni.productshop.model.dto.binding.UserSeedDto;
import softuni.productshop.model.dto.view.ProductInRangeDto;
import softuni.productshop.model.dto.view.UserSellerDto;
import softuni.productshop.model.entity.Product;
import softuni.productshop.model.entity.User;
import softuni.productshop.services.category.CategoryService;
import softuni.productshop.services.product.ProductService;
import softuni.productshop.services.user.UserService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static softuni.productshop.util.beans.BeanRegister.getGson;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.4.2018 г.
 * Time: 16:16 ч.
 */

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    public static final String IODelimiter = System.lineSeparator()
            + new String(new char[30]).replace("\0", "-")
            + System.lineSeparator();


    private final String PROJECT_PATH = System.getProperty("user.dir");
    private final String RECOURCE_PATH = "\\src\\main\\resources";

    private final String USERS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\users.json";
    private final String PRODUCTS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\products.json";
    private final String CATEGORIES_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\categories.json";


    private static final Gson gson = getGson();

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(UserService userService,
                         ProductService productService,
                         CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {

        int usersCount = seedUserData(USERS_FILE_PATH);
        int productCount = seedProductData(PRODUCTS_FILE_PATH, usersCount);
        seedCategoryData(CATEGORIES_FILE_PATH, productCount);

//        getProductsInPriceRangeWithoutBuyerOrderByPrice();

        getSellersWithSoldProductsOrderByLastThenFirstName();
    }

    private void getSellersWithSoldProductsOrderByLastThenFirstName() throws IOException {

        List<UserSellerDto> usersSellerDtos = this.userService
                .getAllSellersWithSoldProducts();

        String jsonOutput = gson.toJson(usersSellerDtos);

        File output = new File(PROJECT_PATH + RECOURCE_PATH
                + "\\JsonOutput\\users-sold-products.json");

        FileUtils.writeStringToFile(output, jsonOutput);
    }

    private void getProductsInPriceRangeWithoutBuyerOrderByPrice() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println(IODelimiter + "Enter min price:");
        BigDecimal minPrice = scanner.nextBigDecimal();

        System.out.println("Enter max price:");
        BigDecimal maxPrice = scanner.nextBigDecimal();

        List<ProductInRangeDto> productsInRangeDto = this.productService
                .getAllWithoutBuyerWithPriceRangeOrderByPriceAsc(minPrice, maxPrice);

        String jsonOutput = gson.toJson(productsInRangeDto);

        File output = new File(PROJECT_PATH + RECOURCE_PATH
                + "\\JsonOutput\\products-in-range.json");

        FileUtils.writeStringToFile(output, jsonOutput);
    }

    private void seedCategoryData(String filePath, int productCount) throws IOException {

        String jsonInput = FileUtils
                .readFileToString(new File(filePath));

        CategorySeedDto[] categorySeedDto = gson
                .fromJson(jsonInput, CategorySeedDto[].class);

        for (CategorySeedDto category : categorySeedDto) {
            Random random = new Random();

            long productId;

            do {
                productId = random.nextInt(productCount) + 1;

                Product product = this.productService
                        .getById(productId);

                Set<Product> products = category.getProducts();

                if (products.contains(product)) {
                    break;
                } else {
                    products.add(product);
                }

                category.setProducts(products);
            }
            while (productId % 3 == 0);
        }

        this.categoryService.save(Arrays.asList(categorySeedDto));
    }

    private int seedProductData(String filePath, int usersCount) throws IOException {

        String jsonInput = FileUtils
                .readFileToString(new File(filePath));

        ProductSeedDto[] productSeedDto = gson
                .fromJson(jsonInput, ProductSeedDto[].class);

        for (ProductSeedDto product : productSeedDto) {
            Random random = new Random();

//            random.nextInt(max - min + 1) + min // includes both min and max
            long sellerId = random.nextInt(usersCount) + 1;

            User seller = this.userService
                    .getById(sellerId);
            product.setSeller(seller);

//            bigger range so there are null values
            long buyerId = random.nextInt(usersCount * 12 / 10);

            if (buyerId <= usersCount && buyerId != sellerId) {
                User buyer = this.userService
                        .getById(buyerId);
                product.setBuyer(buyer);
            }
        }

        this.productService.save(Arrays.asList(productSeedDto));

        return usersCount;
    }

    private void seedFriendsData(int usersCount) {

        Set<UserSeedDto> usersSeedDto = this.userService
                .getAll();

        for (UserSeedDto userSeedDto : usersSeedDto) {

            Random random = new Random();

            long friendId;

            do {
                friendId = random.nextInt(usersSeedDto.size()) + 1;

                User friend = this.userService
                        .getById(friendId);

                Set<User> friends = userSeedDto.getFriends();

                if (friends.contains(friend)) {
                    break;
                } else {
                    friends.add(friend);
                }

                userSeedDto.setFriends(friends);
            }
            while (friendId % 3 == 0);
        }

        this.userService.save(usersSeedDto);
    }

    private int seedUserData(String filePath) throws IOException {

        String jsonInput = FileUtils
                .readFileToString(new File(filePath));

        UserSeedDto[] userSeedDto = gson
                .fromJson(jsonInput, UserSeedDto[].class);

        this.userService.save(Arrays.asList(userSeedDto));

        seedFriendsData(userSeedDto.length);

        return userSeedDto.length;
    }
}