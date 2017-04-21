package com.jpinto.basedepizza.business.interfaces;

import org.springframework.validation.Errors;

public interface PromotionService {
	
	public void createPromotion(String description, int payableQuantity, int freeQuantity, Errors errors);
	
}
