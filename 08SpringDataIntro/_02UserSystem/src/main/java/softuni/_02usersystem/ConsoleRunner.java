package softuni._02usersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni._02usersystem.models.entity.Country;
import softuni._02usersystem.models.entity.Town;
import softuni._02usersystem.models.entity.User;
import softuni._02usersystem.services.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 11:32 ч.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AlbumService albumService;
    private final CountryService countryService;
    private final PictureService pictureService;
    private final TownService townService;
    private final UserService userService;

    @Autowired
    public ConsoleRunner(AlbumService albumService,
                         CountryService countryService,
                         PictureService pictureService,
                         TownService townService,
                         UserService userService) {
        this.albumService = albumService;
        this.countryService = countryService;
        this.pictureService = pictureService;
        this.townService = townService;
        this.userService = userService;
    }


    @Override
    public void run(String... strings) throws Exception {

        Scanner scanner = new Scanner(System.in);

        initialCountryTestData();
        initialTownTestDate();
        initialUserTestData();

        System.out.println("Enter email host:");
        printUsernameEmailByHost(scanner.nextLine());

        System.out.println("Enter date:");
        setIsDeleteIfLastLoggedAfter(scanner.nextLine());
        deleteUsersWithIsDeletedTrue();
    }

    private void deleteUsersWithIsDeletedTrue() {

        Set<User> isDeleteUsers = this.userService
                .getByIsDeleted(true);

        isDeleteUsers
                .stream()
                .forEach(this.userService::deleteUser);

    }

    private void setIsDeleteIfLastLoggedAfter(String dateString) {

        Date date = parseDate(dateString);

        Set<User> lastLogBeforeUsers = this.userService
                .getByLastLogBefore(date);

        Set<User> lastLogBeforeActiveUsers = lastLogBeforeUsers
                .stream()
                .filter(u -> !u.isDeleted())
                .collect(Collectors.toSet());

        lastLogBeforeActiveUsers
                .stream()
                .forEach(u -> {
                    u.setDeleted(true);
                    userService.registerUser(u);
                });

    }

    private Date parseDate(String dateString) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Date date = null;

        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private void printUsernameEmailByHost(String host) {

        Set<User> usersByHost = this.userService
                .getByEmailHost(host);

        usersByHost
                .stream()
                .forEach(u -> System.out.println(u.getEmail()));
    }

    private void initialCountryTestData() {

        Country currentCountry = new Country();
        currentCountry.setName("Bulgaria");

        this.countryService.registerCountry(currentCountry);

    }

    private void initialTownTestDate() {

        String name = "Rousse";

        int townCount = 6;
        for (int i = 1; i <= townCount; i++) {
            Town currentTown = new Town();
            currentTown.setName(name + i);
            currentTown.setCountry(countryService.getCountryById(1L));

            this.townService.registerTown(currentTown);
        }
    }

    private void initialUserTestData() {

        String username = "peshoU";
        String password = "Stamat";
        String email = "pesho@";
        Date date = new Date();
        int age = 25;
        boolean isDeleted = true;
        String firstName = "pesho";
        String lastName = "stamatov";

        int userCount = 5;
        for (int i = 1; i <= userCount; i++) {
            User currentUser = new User();
            currentUser.setUsername(username + i);
            currentUser.setPassword(password + i);
            if (i % 2 == 0)
                currentUser.setEmail(i + email + "gmail.com");
            else
                currentUser.setEmail(i + email + "abv.bg");
            currentUser.setUserRegistration(new Date(date
                    .getTime() - (i * 24 * 3600 * 1000L)));
            currentUser.setUserLastLog(new Date(date
                    .getTime() - (i * 24 * 3600 * 1000L)));
            currentUser.setAge(age + i);
            if (i % 2 == 0)
                currentUser.setDeleted(isDeleted);
            else
                currentUser.setDeleted(!isDeleted);
            currentUser.setBornTown(townService.getTownById((long) i));
            currentUser.setCurrentTown(townService.getTownById((long) (userCount + 1 - i)));
            currentUser.setFirstName(firstName + i);
            currentUser.setLastName(lastName + i);

            this.userService.registerUser(currentUser);
        }
    }
}