package com.mohamed.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HelperValidationClass implements ConstraintValidator<CustomValidation,String>{

	
	private String [] items;
	
	@Override
	public void initialize(CustomValidation constraintAnnotation) {
		items  = constraintAnnotation.value();
		
	}
	
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext arg1) {
		
		boolean result = false;
		
		
		if(input != null && input.length()>=1) {
			
			for(String word : items) {
				
				result = input.endsWith(word);
				
				if(result)
					break;
				
			}
			
			
		}else {
			
			result = true;
			
		}
		
		return result;
	}

}
