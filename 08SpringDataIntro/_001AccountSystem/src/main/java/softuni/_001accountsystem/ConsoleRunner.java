package softuni._001accountsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import softuni._001accountsystem.models.entities.Account;
import softuni._001accountsystem.models.entities.User;
import softuni._001accountsystem.services.AccountServiceImpl;
import softuni._001accountsystem.services.UserServiceImpl;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 10:19 ч.
 */
@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService,
                         AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {

        User example = new User();
        example.setUsername("example");
        example.setAge(20);

        userService.registerUser(example);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));

        account.setUser(userService
                .getUserByUsername(example
                        .getUsername()));

        accountService.createNewAccount(account);

        accountService
                .withdrawMoney(new BigDecimal(20000),
                        example.getUsername());
        accountService
                .depositMoney(new BigDecimal(9999),
                        example.getUsername());


        accountService
                .withdrawMoney(new BigDecimal(15000),
                        example.getUsername());

        userService.registerUser(example);
    }
}