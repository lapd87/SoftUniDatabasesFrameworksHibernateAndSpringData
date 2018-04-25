package softuni.productshop2;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import softuni.productshop2.io.reader.Reader;
import softuni.productshop2.io.writer.Writer;
import softuni.productshop2.io.xmlParser.XmlParser;
import softuni.productshop2.model.dto.binding.*;
import softuni.productshop2.model.dto.view.ProductInRangeDto;
import softuni.productshop2.model.dto.view.ProductInRangeWrapper;
import softuni.productshop2.model.dto.view.UserSoldDto;
import softuni.productshop2.model.dto.view.UserSoldWrapper;
import softuni.productshop2.services.category.CategoryService;
import softuni.productshop2.services.product.ProductService;
import softuni.productshop2.services.user.UserService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static softuni.productshop2.util.beans.BeanRegister.getGson;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.4.2018 г.
 * Time: 16:16 ч.
 */

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    public static final String INPUT_ERROR_MSG = "Invalid input";

    public static final String IODelimiter = System.lineSeparator()
            + new String(new char[30]).replace("\0", "-")
            + System.lineSeparator();

    private final String PROJECT_PATH = System.getProperty("user.dir");
    private final String RESOURCE_PATH = "\\src\\main\\resources";

    private final String XML_INPUT = "\\XmlInput\\";
    private final String XML_OUTPUT = "\\XmlOutput\\";


    private final String XML_USERS_INPUT = PROJECT_PATH + RESOURCE_PATH
            + XML_INPUT + "users.xml";
    private final String XML_PRODUCTS_INPUT = PROJECT_PATH + RESOURCE_PATH
            + XML_INPUT + "products.xml";
    private final String XML_CATEGORIES_INPUT = PROJECT_PATH + RESOURCE_PATH
            + XML_INPUT + "categories.xml";

    private final String XML_PRODUCTS_IN_RANGE_OUTPUT = PROJECT_PATH + RESOURCE_PATH
            + XML_OUTPUT + "products-in-range.xml";

    private final String XML_USER_SOLD_OUTPUT = PROJECT_PATH + RESOURCE_PATH
            + XML_OUTPUT + "users-sold-products.xml";


    private final String XML = "XML";
    private final String JSON = "JSON";

    private static final Gson GSON = getGson();

    private final Writer writer;
    private final Reader reader;
    private final XmlParser xmlParser;


    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;


    @Autowired
    public ConsoleRunner(Writer writer,
                         Reader reader,
                         XmlParser xmlParser,
                         UserService userService,
                         ProductService productService,
                         CategoryService categoryService) {
        this.writer = writer;
        this.reader = reader;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) {

        seedUsers(XML_USERS_INPUT, XML);
        seedProducts(XML_PRODUCTS_INPUT, XML);
        seedCategories(XML_CATEGORIES_INPUT, XML);


//        getProductsInPriceRange(XML_PRODUCTS_IN_RANGE_OUTPUT, XML);
        getUserSoldProducts(XML_USER_SOLD_OUTPUT, XML);
    }

    private void getUserSoldProducts(String filePath, String xmlOrJson) {

        List<UserSoldDto> userSoldDtos = this.userService
                .getUserWithSoldProductsOrdered();

        String output = "";

        switch (xmlOrJson) {
            case "XML":
                output = this.xmlParser
                        .serialize(new UserSoldWrapper(userSoldDtos));
                break;
            case "JSON":
                output = GSON.toJson(userSoldDtos);
                break;
        }

        this.writer.writeAll(output, filePath);
    }

    private void getProductsInPriceRange(String filePath, String xmlOrJson) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(IODelimiter + "Enter min price:");
        BigDecimal minPrice = scanner.nextBigDecimal();

        System.out.println("Enter max price:");
        BigDecimal maxPrice = scanner.nextBigDecimal();

        List<ProductInRangeDto> productInRangeDtos = this.productService
                .getByPriceRangeOrdered(minPrice, maxPrice);

        String output = "";

        switch (xmlOrJson) {
            case "XML":
                output = this.xmlParser
                        .serialize(new ProductInRangeWrapper(productInRangeDtos));
                break;
            case "JSON":
                output = GSON.toJson(productInRangeDtos);
                break;
        }

        this.writer.writeAll(output, filePath);

    }

    private void seedCategories(String filePath, String xmlOrJson) {

        String input = this.reader.readAll(filePath);

        List<CategorySeedDto> categorySeedDtos = new ArrayList<>();

        switch (xmlOrJson) {
            case "XML":
                categorySeedDtos = this.xmlParser
                        .deserialize(input, CategorySeedWrapper.class)
                        .getCategorySeedDtos();
                break;
            case "JSON":
                categorySeedDtos = Arrays.asList(GSON
                        .fromJson(input, CategorySeedDto[].class));
                break;
        }

        this.categoryService
                .seedWithRandomProducts(categorySeedDtos);
    }

    private void seedProducts(String filePath, String xmlOrJson) {

        String input = this.reader.readAll(filePath);

        List<ProductSeedDto> productSeedDtos = new ArrayList<>();

        switch (xmlOrJson) {
            case "XML":
                productSeedDtos = this.xmlParser
                        .deserialize(input, ProductSeedWrapper.class)
                        .getProductSeedDtos();
                break;
            case "JSON":
                productSeedDtos = Arrays.asList(GSON
                        .fromJson(input, ProductSeedDto[].class));
                break;
        }

        this.productService
                .seedWithRandomSellerBuyer(productSeedDtos);
    }

    private void seedUsers(String filePath, String xmlOrJson) {

        String input = this.reader.readAll(filePath);

        List<UserSeedDto> userSeedDtos = new ArrayList<>();

        switch (xmlOrJson) {
            case "XML":
                userSeedDtos = this.xmlParser
                        .deserialize(input, UserSeedWrapper.class)
                        .getUserSeedDtos();
                break;
            case "JSON":
                userSeedDtos = Arrays.asList(GSON
                        .fromJson(input, UserSeedDto[].class));
                break;
        }

        this.userService
                .seedWithRandomFriends(userSeedDtos);
    }
}