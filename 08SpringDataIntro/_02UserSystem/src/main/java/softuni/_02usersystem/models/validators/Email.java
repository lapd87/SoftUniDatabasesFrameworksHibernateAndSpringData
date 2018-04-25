package softuni._02usersystem.models.validators;

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
 * Date: 1.4.2018 г.
 * Time: 12:19 ч.
 */
// not working
@Component
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    String message() default "Invalid Email format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
