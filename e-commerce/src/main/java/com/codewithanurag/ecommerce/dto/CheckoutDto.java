package com.codewithanurag.ecommerce.dto;

import com.codewithanurag.ecommerce.model.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckoutDto {
	
	//private String userName;
	//private double total;
	private String cartQuantity;
	private Item item;

}
