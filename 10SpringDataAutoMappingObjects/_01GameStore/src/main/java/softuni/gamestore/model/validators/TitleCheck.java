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
 * Time: 17:44 ч.
 */
@Component
@Constraint(validatedBy = TitleCheckValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TitleCheck {

    String message() default "Invalid title format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
