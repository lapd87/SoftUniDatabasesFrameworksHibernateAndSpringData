package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 18:08 ч.
 */
@Component
public class URLCheckValidator
        implements ConstraintValidator<URLCheck, String> {


    @Override
    public void initialize(URLCheck urlCheck) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        return url.matches("^http[s]{0,1}:\\/\\/\\w+.*\\w+$");
    }
}