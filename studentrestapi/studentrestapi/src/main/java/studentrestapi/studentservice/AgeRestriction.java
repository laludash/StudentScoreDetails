package studentrestapi.studentservice;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;
@Constraint(validatedBy = AgeRestrictionValidator.class)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeRestriction {
	String message() default "Age should be greater than 15 and less than or equal to 20";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
