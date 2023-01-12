package com.codewithanurag.ecommerce.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithanurag.ecommerce.dto.ItemDto;
import com.codewithanurag.ecommerce.exceptions.NotFoundException;
import com.codewithanurag.ecommerce.exceptions.ResourceNotFoundException;
import com.codewithanurag.ecommerce.model.Images;
import com.codewithanurag.ecommerce.model.Item;
import com.codewithanurag.ecommerce.repository.ItemImagesRepo;
import com.codewithanurag.ecommerce.repository.ItemRepo;
import com.codewithanurag.ecommerce.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ItemImagesRepo itemImagesRepo;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public ItemDto createItem(ItemDto itemDto, Integer imageId) throws NotFoundException {
		Item savedItem = new Item();
		Images image = this.itemImagesRepo.findById(imageId).orElseThrow(()-> new ResourceNotFoundException("image", "Id", imageId));
		Item item = dtoToItem(itemDto);
		item.setImages(image);
		if (item.getQuantity()>0) {
			 savedItem = this.itemRepo.save(item);
			
		}
		else {
			throw new NotFoundException("Quantity should be greater than 0");
		}
		
		return itemToDto(savedItem);
	}
	

	@Override
	public ItemDto getItemById(Integer itemId) {
		Item item = this.itemRepo.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "Id", itemId));
		return this.itemToDto(item);
	}

	@Override
	public List<ItemDto> getAllItems() {
		List<Item> items = this.itemRepo.findAll();
		List<ItemDto> itemDtos = items.stream().map(item -> this.itemToDto(item)).collect(Collectors.toList());
		return itemDtos;
	}

	/*
	 * Converter dto to model
	 */
	public Item dtoToItem(ItemDto itemDto) {
		Item item = this.modelMapper.map(itemDto, Item.class);
		return item;
	}

	public ItemDto itemToDto(Item item) {
		ItemDto itemDto = this.modelMapper.map(item, ItemDto.class);
		return itemDto;
	}

	
}
