package studentrestapi.studentservice;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AgeRestrictionValidator implements ConstraintValidator<AgeRestriction, LocalDate> {

	 private static final int MIN_AGE = 15;
	    private static final int MAX_AGE = 20;
	@Override
	public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
	
		if(dateOfBirth == null)
		{
			return false;
		}
		LocalDate now = LocalDate.now();
		int age = Period.between(dateOfBirth, now).getYears();
		
		return age>MIN_AGE && age <= MAX_AGE;
	}

}
