package com.codewithanurag.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_Images")
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Images {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String type;
	
	private String imagePath;
	
//	 @OneToOne(targetEntity = Item.class, cascade = CascadeType.ALL,fetch =  FetchType.EAGER)
//			  @JoinColumn(name = "Product_Item_Id", referencedColumnName = "id")
//			  private Item item;

	public Images(int id, String name, String type, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imagePath = imagePath;
		
	}
	
	
}
