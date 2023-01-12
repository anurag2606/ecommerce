package com.codewithanurag.ecommerce.services;

import java.util.List;

import com.codewithanurag.ecommerce.dto.ItemDto;
import com.codewithanurag.ecommerce.exceptions.NotFoundException;

public interface ItemService {

	ItemDto createItem(ItemDto itemDto, Integer imageId)throws NotFoundException;

	ItemDto getItemById(Integer itemId);

	List<ItemDto> getAllItems();

//	ItemDto uploadImages(MultipartFile file,ItemDto itemDto) throws IOException;

}
