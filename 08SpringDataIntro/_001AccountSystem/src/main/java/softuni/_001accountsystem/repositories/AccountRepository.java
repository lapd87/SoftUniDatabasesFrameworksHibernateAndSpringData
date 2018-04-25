package softuni._001accountsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softuni._001accountsystem.models.entities.Account;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 30.3.2018 г.
 * Time: 17:49 ч.
 */

@Repository
public interface AccountRepository
        extends CrudRepository<Account, Long> {

    Account getByUserUsername(String username);

    Account getByBalanceLessThan(BigDecimal ballance);

}