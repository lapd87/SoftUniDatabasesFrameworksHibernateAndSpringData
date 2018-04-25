package softuni.gamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import softuni.gamestore.model.dto.game.GameAddDto;
import softuni.gamestore.model.dto.game.GameDetailDto;
import softuni.gamestore.model.dto.game.GameOwnedDto;
import softuni.gamestore.model.dto.game.GamePrintDto;
import softuni.gamestore.model.dto.user.*;
import softuni.gamestore.model.validators.TitleCheck;
import softuni.gamestore.services.game.GameService;
import softuni.gamestore.services.user.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 16:31 ч.
 */
@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    private final Set<Long> loggedUsers;

    public static final String IODelimiter = System.lineSeparator()
            + new String(new char[30]).replace("\0", "-")
            + System.lineSeparator();

    @Autowired
    public ConsoleRunner(UserService userService,
                         GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.loggedUsers = new HashSet<>();
    }

    @Override
    public void run(String... args) throws Exception {

// I have changed the logic a little -
// I keep a set of users logged and check for ADMIN in the set
// also I need user Id for view and shopping
        readCommand();

    }

    private void readCommand() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(IODelimiter);
            System.out.println("Enter command or 'END':");

            String[] inputArgs = reader
                    .readLine()
                    .split("\\|");

            String command = inputArgs[0];

            switch (command) {
                case "RegisterUser":
                    registerUser(inputArgs);
                    break;
                case "LoginUser":
                    loginUser(inputArgs);
                    break;
                case "LogoutUser":
                    logoutUser(inputArgs);
                    break;
                case "AddGame":
                    addGame(inputArgs);
                    break;
                case "EditGame":
                    editGame(inputArgs);
                    break;
                case "DeleteGame":
                    deleteGame(inputArgs);
                    break;
                case "AllGame":
                    printAllGames();
                    break;
                case "DetailGame":
                    printGameDetail(inputArgs);
                    break;
                case "OwnedGame":
                    ownedGames(inputArgs);
                    break;
                case "AddItem":
                    addItemToCart(inputArgs);
                    break;
                case "RemoveItem":
                    removeItemFromCart(inputArgs);
                    break;
                case "BuyItem":
                    buyItemsFromCart(inputArgs);
                    break;
                case "END":
                    return;
                default:
                    invalidInput();
            }
        }
    }

    private void buyItemsFromCart(String[] inputArgs) {

        try {
            Long id = Long.parseLong(inputArgs[1]);

            if (!loggedUsers.contains(id)) {
                userNotLogged();
            } else {

                Set<GameOwnedDto> shoppingCartGames = this.userService
                        .getGamesShoppingCartByUserId(id);

                if (shoppingCartGames.size() == 0) {
                    System.out.println(IODelimiter + "No games in cart");
                } else {
                    boolean gamesBought = this.userService
                            .buyGamesFromShoppingCart(id);

                    if (gamesBought) {
                        System.out.println(IODelimiter + "Successfully bought games:");
                        shoppingCartGames
                                .forEach(g ->
                                        System.out.println("\t-" + g.getTitle()));
                    }
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void removeItemFromCart(String[] inputArgs) {

        try {
            Long id = Long.parseLong(inputArgs[1]);

            if (!loggedUsers.contains(id)) {
                userNotLogged();
            } else {
                String title = inputArgs[2];

                GameOwnedDto gameToRemove = new GameOwnedDto(title);

                Set<GameOwnedDto> shoppingCartGames = this.userService
                        .getGamesShoppingCartByUserId(id);

                Set<String> titlesInShoppingCart = new HashSet<>();

                shoppingCartGames.forEach(g -> titlesInShoppingCart.add(g.getTitle()));

                if (!titlesInShoppingCart.contains(title)) {
                    System.out.println(IODelimiter + "No such game in cart");
                } else {
                    boolean gameRemovedFromCart = this.userService
                            .addGameToShoppingCart(id, title);

                    if (gameRemovedFromCart) {
                        System.out.println(IODelimiter
                                + title + " removed from cart");
                    }
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void addItemToCart(String[] inputArgs) {

        try {
            Long id = Long.parseLong(inputArgs[1]);

            if (!loggedUsers.contains(id)) {
                userNotLogged();
            } else {
                String title = inputArgs[2];

                GameOwnedDto gameToAdd = new GameOwnedDto(title);

                Set<GameOwnedDto> ownedGames = this.userService
                        .getGamesOwnedDtoByUserId(id);

                Set<String> titlesOwned = new HashSet<>();

                ownedGames.forEach(g -> titlesOwned.add(g.getTitle()));

                if (titlesOwned.contains(title)) {
                    System.out.println(IODelimiter + "Game already bought");
                } else {
                    Set<GameOwnedDto> shoppingCartGames = this.userService
                            .getGamesShoppingCartByUserId(id);

                    if (shoppingCartGames.contains(gameToAdd)) {
                        System.out.println(IODelimiter + "Game already added");
                    } else {
                        boolean gameAddedToCart = this.userService
                                .addGameToShoppingCart(id, title);

                        if (gameAddedToCart) {
                            System.out.println(IODelimiter
                                    + title + " added to cart");
                        }
                    }
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void ownedGames(String[] inputArgs) {

        try {
            Long id = Long.parseLong(inputArgs[1]);

            if (!loggedUsers.contains(id)) {
                userNotLogged();
            } else {

                Set<GameOwnedDto> gameOwnedDtos = this.userService
                        .getGamesOwnedDtoByUserId(id);

                if (gameOwnedDtos != null) {

                    if (gameOwnedDtos.size() == 0) {
                        System.out.println(IODelimiter + "No owned games");
                    } else {
                        System.out.println(IODelimiter);
                        gameOwnedDtos
                                .forEach(g -> System.out
                                        .println(g.getTitle()));
                    }
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void printGameDetail(String[] inputArgs) {
        try {
            String title = inputArgs[1];

            GameDetailDto gameDetailDto = this.gameService
                    .getByTitleDetailDto(title);

            if (gameDetailDto != null) {
                System.out.println(IODelimiter + gameDetailDto.toString());
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void printAllGames() {

        List<GamePrintDto> games = this.gameService
                .getAllPrintDto();

        if (games.size() > 0) {
            System.out.println(IODelimiter);
            games.forEach(g -> System.out.printf("%s %.2f%n",
                    g.getTitle(), g.getPrice()));
        } else {
            System.out.println(IODelimiter + "No games in DB");
        }
    }

    private void deleteGame(String[] inputArgs) {
        boolean hasAdmin = checkForLoggedAdmin();

        try {
            if (hasAdmin) {

                Long id = Long.valueOf(inputArgs[1]);

                String title = this.gameService
                        .getTitleById(id);

                boolean isDeleted = this.gameService
                        .deleteGame(id);

                if (isDeleted) {
                    System.out.println(IODelimiter + "Deleted " + title);
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void editGame(String[] inputArgs) {

        boolean hasAdmin = checkForLoggedAdmin();

        try {
            if (hasAdmin) {

                boolean isEdited = this.gameService
                        .editGame(inputArgs);

                if (isEdited) {

                    Long id = Long.valueOf(inputArgs[1]);

                    String title = this.gameService
                            .getTitleById(id);

                    System.out.println(IODelimiter + "Edited " + title);
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void addGame(String[] inputArgs) {

        boolean hasAdmin = checkForLoggedAdmin();

        if (hasAdmin) {
            try {
                String title = inputArgs[1];
                BigDecimal price = BigDecimal
                        .valueOf(Double
                                .parseDouble(inputArgs[2]));
                Double size = Double.parseDouble(inputArgs[3]);

                String[] trailerInput = inputArgs[4].split("=",2);

                String trailer = trailerInput[0];
                if (trailerInput.length > 1) {
                    trailer = trailerInput[1];
                }

                String thumbnailUrl = inputArgs[5];
                String description = inputArgs[6];
                Date releaseDate = parseDate(inputArgs[7]);

                GameAddDto game = new GameAddDto(title, trailer,
                        thumbnailUrl, size, price, description,
                        releaseDate);

                boolean isAdded = this.gameService
                        .addGame(game);

                if (isAdded) {
                    System.out.println(IODelimiter + "Added " + title);
                }
            } catch (Exception e) {
                invalidInput();
            }
        }
    }

    private boolean checkForLoggedAdmin() {

        if (loggedUsers.size() == 0) {
            System.out.println(IODelimiter + "No logged user");
            return false;
        } else {
            return this.userService
                    .checkAdminById(loggedUsers);
        }
    }

    private void logoutUser(String[] inputArgs) {

        try {
            String email = inputArgs[1];

            UserLogoutDto user = new UserLogoutDto(email);

            UserExistsDto userExistsDto = this.userService
                    .logoutUser(user);

            if (userExistsDto != null) {

                Long id = userExistsDto.getId();
                String name = userExistsDto.getName();

                if (!loggedUsers.contains(id)) {
                    System.out.println(IODelimiter + "Cannot log out. The user was not logged in.");
                } else {
                    loggedUsers.remove(id);
                    System.out.println(IODelimiter + "User " + name
                            + " successfully logged out");
                }
            }
        } catch (Exception e) {
            invalidInput();
        }
    }

    private void loginUser(String[] inputArgs) {

        try {
            String email = inputArgs[1];
            String password = inputArgs[2];

            UserLoginDto user = new UserLoginDto(email, password);

            UserExistsDto userExistsDto = this.userService
                    .loginUser(user);

            if (userExistsDto != null) {

                Long id = userExistsDto.getId();
                String name = userExistsDto.getName();

                if (loggedUsers.contains(id)) {
                    System.out.println(IODelimiter + "Already logged in");
                } else {
                    loggedUsers.add(id);
                    System.out.println(IODelimiter + "Successfully logged in "
                            + name);
                }
            }
        } catch (Exception e) {
            invalidInput();
        }

    }

    private void registerUser(String[] inputArgs) {

        try {
            String email = inputArgs[1];
            String password = inputArgs[2];
            String confirmPassword = inputArgs[3];
            String fullName = inputArgs[4];

            UserRegisterDto user = new UserRegisterDto(email,
                    password, confirmPassword, fullName);

            boolean isRegistered = this.userService
                    .registerUser(user);

            if (isRegistered)
                System.out.println(IODelimiter + fullName + " was registered");

        } catch (Exception e) {
            invalidInput();
        }
    }

    private void userNotLogged() {
        System.out.println(IODelimiter + "User is not loggged in");
    }

    public static void invalidInput() {
        System.out.println(IODelimiter + "Invalid input");
    }

    public static void noSuchGame() {
        System.out.println(IODelimiter + "No such game in DB");
    }

    public static void noSuchUser() {
        System.out.println(IODelimiter + "No such user in DB");
    }

    public static void noAdmin() {
        System.out.println(IODelimiter + "No admin rights");
    }

    public static Date parseDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        Date releaseDate = null;

        try {
            releaseDate = formatter.parse(date);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("d-M-yyyy");
            try {
                releaseDate = formatter.parse(date);
            } catch (ParseException e1) {
                formatter = new SimpleDateFormat("dd MMM yyyy",
                        Locale.ENGLISH);
                try {
                    releaseDate = formatter.parse(date);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }

            }
        }

        return releaseDate;
    }

}