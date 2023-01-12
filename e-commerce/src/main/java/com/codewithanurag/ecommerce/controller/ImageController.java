package com.codewithanurag.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codewithanurag.ecommerce.services.ImageService;


@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/uploadImages")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws  IOException{
		String uploadImage = imageService.uploadImages(file);
		return  ResponseEntity.status(HttpStatus.OK).body(uploadImage);
		
	}
	
//	@GetMapping("/{imageId}")
//	public ResponseEntity<Images> getItemById(@PathVariable Integer imageId){
//		return new ResponseEntity<>(imageService.getImageById(imageId), HttpStatus.OK);
	
	}


