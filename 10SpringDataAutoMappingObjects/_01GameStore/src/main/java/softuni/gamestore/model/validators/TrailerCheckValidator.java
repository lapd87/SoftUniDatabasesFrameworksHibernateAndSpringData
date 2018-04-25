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
public class TrailerCheckValidator
        implements ConstraintValidator<TrailerCheck, String> {

    @Override
    public void initialize(TrailerCheck trailerCheck) {

    }

    @Override
    public boolean isValid(String trailer, ConstraintValidatorContext constraintValidatorContext) {
        return trailer.matches("^\\w{11}$");
    }
}