package com.codewithanurag.ecommerce.service.Impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithanurag.ecommerce.model.Images;
import com.codewithanurag.ecommerce.repository.ItemImagesRepo;
import com.codewithanurag.ecommerce.services.ImageService;

@Service
public class ImageServiceimpl implements ImageService {

	@Autowired
	private ItemImagesRepo itemImagesRepo;


	private final String FOLDER_PATH = "C:/Users/hp/Desktop/MyFiles/";

	@Override
	public String uploadImages(MultipartFile file) throws IOException {

		String filePath = FOLDER_PATH + file.getOriginalFilename();

		// Item item = itemRepo.findById(itemId).orElseThrow(()-> new
		// ResourceNotFoundException("Item", "Id", itemId));

		Images itemImages = itemImagesRepo.save(Images.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imagePath(filePath).build());

		file.transferTo(new File(filePath));

		if (itemImages != null) {
			return "image uploaded successfully : " + filePath;
		}
		return null;
	}

//	@Override
//	public Images getImageById(Integer imageId) {
//		Images images = this.itemImagesRepo.findById(imageId)
//				.orElseThrow(() -> new ResourceNotFoundException("image", "Id", imageId));
//		return images;
//	}
}
