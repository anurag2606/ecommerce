package com.codewithanurag.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemImagesDto {

	private int id;
	private String name;
	private String type;
	private String imagePath;
	public ItemImagesDto(int id, String name, String type, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imagePath = imagePath;
	}
	
	
}
