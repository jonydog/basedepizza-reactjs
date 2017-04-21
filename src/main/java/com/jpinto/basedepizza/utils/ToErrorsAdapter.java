package com.jpinto.basedepizza.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ToErrorsAdapter {
	
	
	public static <T> void toErrors(Set<ConstraintViolation<T>> violationSet, T object, Errors errors){
		
		for( ConstraintViolation<T> v : violationSet ){
			
			errors.rejectValue( v.getPropertyPath().toString() , v.getMessage(), v.getMessage() );
			
		}
		
	}
	
	public static <T> List<String> toErrors(Errors errors){
		
		ArrayList<String> errorMessages = new ArrayList<>();
		
		
		for( FieldError error : errors.getFieldErrors()  ){			
			errorMessages.add( "Field : [ " + error.getField() + " ] " + error.getCode() );
		}
		
		for( ObjectError error : errors.getGlobalErrors()  ){			
			errorMessages.add( "Object error: " + error.getDefaultMessage());
		}
		
		return errorMessages;
	}

}