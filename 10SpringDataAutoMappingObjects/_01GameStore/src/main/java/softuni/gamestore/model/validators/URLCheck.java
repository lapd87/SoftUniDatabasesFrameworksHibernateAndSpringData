package softuni.gamestore.model.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 18:08 ч.
 */
@Component
@Constraint(validatedBy = URLCheckValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface URLCheck {
    String message() default "Invalid thumbnail URL format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
