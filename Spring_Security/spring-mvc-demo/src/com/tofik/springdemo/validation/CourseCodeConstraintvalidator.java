package com.tofik.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintvalidator 
	implements ConstraintValidator<CourseCode, String>{

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
		
	}

	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result=false;
		
		
		if (theCode != null) {
			
			// loop through course prefixes 
			// check to see if code matches any of the course prefix
			
			for(String tempPrefix : coursePrefix) {
				result = theCode.startsWith(tempPrefix);
				
				// if we found a match then break out of the loop
				if(result) {
					break;
				}
			}
		
		}
		else {
			result = true;
		}
		
		return result;
	}

}
