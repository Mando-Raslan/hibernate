package com.mohamed.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = HelperValidationClass.class)
@Target({ElementType.METHOD , ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidation {
	
	public String[] value()  default "@yahoo.com";
	
	public String message() default "must end with @....";
	
	
	public Class<?>[]  groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
}
