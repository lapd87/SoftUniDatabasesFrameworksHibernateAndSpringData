package softuni._001accountsystem.services;

import softuni._001accountsystem.models.entities.Account;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:55 ч.
 */
public interface AccountService {

    void createNewAccount(Account account);

    void withdrawMoney(BigDecimal money, String username);
    void depositMoney(BigDecimal money, String username);
}
