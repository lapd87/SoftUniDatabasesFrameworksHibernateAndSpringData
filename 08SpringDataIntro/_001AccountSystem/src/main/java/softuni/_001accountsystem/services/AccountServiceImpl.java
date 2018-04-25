package softuni._001accountsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import softuni._001accountsystem.models.entities.Account;
import softuni._001accountsystem.repositories.AccountRepository;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:58 ч.
 */

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, String username) {
        Account account = this.accountRepository.getByUserUsername(username);
        BigDecimal balance = account.getBalance();
        BigDecimal futureBalance = balance.subtract(money);
        if (futureBalance.compareTo(BigDecimal.ZERO) >= 0) {
            account.setBalance(futureBalance);
            this.accountRepository.save(account);
        } else System.out.println("not enough funds");
    }

    @Override
    public void depositMoney(BigDecimal money, String username) {
        Account account = this.accountRepository.getByUserUsername(username);
        account.setBalance(account.getBalance().add(money));
        this.accountRepository.save(account);
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountRepository.save(account);
    }
}