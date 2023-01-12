package com.codewithanurag.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "product_Details")
@NoArgsConstructor
@Getter
@Setter

public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for Id Auto Increment
	private int id;

	private String item;

	private int price;

	private String description;

	private int quantity;

//	private String name;
//
//	private String type;
//
//	private String imagePath;

	@OneToOne(targetEntity = Images.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Product_Image_Id", referencedColumnName = "id")
	private Images images;
	
	@OneToOne(targetEntity = Checkout.class, cascade = CascadeType.ALL)
	private Checkout checkout;

}
