package com.jpinto.basedepizza.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResult<T> {
	
	private List<String>		errors;
	private  	T 				result;

}