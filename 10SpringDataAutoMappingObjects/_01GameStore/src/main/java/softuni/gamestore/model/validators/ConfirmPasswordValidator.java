package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;
import softuni.gamestore.model.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 17:09 ч.
 */
@Component
public class ConfirmPasswordValidator
        implements ConstraintValidator<ConfirmPassword, String> {


    @Override
    public void initialize(ConfirmPassword confirmPassword) {

    }

    @Override
    public boolean isValid(String confirmPassword, ConstraintValidatorContext constraintValidatorContext) {
//        Method methodGetPassword = UserRegisterDto.class.getClass().getMethod("getPassword");
//        Method methodGetConfirmpassword = candidate.getClass().getMethod("getConfirmpassword");
//
//        return methodGetPassword.invoke(candidate).equals(methodGetConfirmpassword.invoke(candidate));
        return false;
    }
}