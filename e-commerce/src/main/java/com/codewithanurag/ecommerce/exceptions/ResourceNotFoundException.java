package com.codewithanurag.ecommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	String resouceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resouceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s :%s", resouceName, fieldName, fieldValue));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
