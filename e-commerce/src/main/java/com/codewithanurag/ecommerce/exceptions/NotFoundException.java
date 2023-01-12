package com.codewithanurag.ecommerce.exceptions;

public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	String resouceName;
	public NotFoundException(String resouceName) {
		super(String.format("%s", resouceName));
		this.resouceName = resouceName;
	}

}
