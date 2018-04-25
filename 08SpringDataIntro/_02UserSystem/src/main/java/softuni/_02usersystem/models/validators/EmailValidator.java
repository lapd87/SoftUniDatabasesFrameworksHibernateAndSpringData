package softuni._02usersystem.models.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.4.2018 г.
 * Time: 12:20 ч.
 */
// not working

@Component
public class EmailValidator
        implements ConstraintValidator<Email, String> {


    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (!email.matches("^[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$")) {
            return false;
        }
        return true;
    }
}