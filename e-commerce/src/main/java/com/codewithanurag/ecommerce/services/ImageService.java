package com.codewithanurag.ecommerce.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	String uploadImages(MultipartFile file) throws IOException;
	
	//Images getImageById(Integer imageId);

}
