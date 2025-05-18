package com.codewithanurag.ecommerce.dto;

import com.codewithanurag.ecommerce.model.Images;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
	private int id;
	private String item;
	private int price;
	private String description;
	private int quantity;
	private Images images;
}
