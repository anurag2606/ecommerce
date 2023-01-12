package com.codewithanurag.ecommerce.services;

import com.codewithanurag.ecommerce.dto.CheckoutDto;

public interface CheckoutService {
	
	CheckoutDto createCheckoutItem(CheckoutDto checkoutDto, Integer itemId) throws Exception;
	
	void deleteCkeckoutItem(Integer checkoutId);

}
