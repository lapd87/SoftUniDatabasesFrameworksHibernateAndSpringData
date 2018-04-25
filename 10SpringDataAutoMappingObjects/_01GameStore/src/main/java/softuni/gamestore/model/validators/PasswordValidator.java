package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;

import javax.swing.text.ComponentView;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 16:58 ч.
 */
@Component
public class PasswordValidator
        implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext constraintValidatorContext) {

        boolean hasCapitalCase = hasCapitalCase(password);
        boolean hasLowerCase = hasLowerCase(password);
        boolean hasDigit = hasDigit(password);


        return hasCapitalCase && hasLowerCase && hasDigit;
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z]+.*");
    }

    private boolean hasDigit(String password) {

        return password.matches(".*\\d+.*");
    }

    private boolean hasCapitalCase(String password) {

        return password.matches(".*[A-Z]+.*");
    }
}