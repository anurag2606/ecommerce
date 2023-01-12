package com.codewithanurag.ecommerce.dto;

import com.codewithanurag.ecommerce.model.Checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseItemDto {
	
	
	private Checkout checkout;

}
