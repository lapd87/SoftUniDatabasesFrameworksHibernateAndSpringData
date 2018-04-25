package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 16:55 ч.
 */
@Component
public class EmailValidator
        implements ConstraintValidator<Email, String> {


    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext constraintValidatorContext) {

        return email.matches("^\\S+[@]\\S+\\.\\S+$");
    }
}