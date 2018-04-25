package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 17:44 ч.
 */
@Component
public class TitleCheckValidator
        implements ConstraintValidator<TitleCheck, String> {


    @Override
    public void initialize(TitleCheck titleCheck) {

    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return title.matches("^[A-Z].{2,99}$");
    }
}