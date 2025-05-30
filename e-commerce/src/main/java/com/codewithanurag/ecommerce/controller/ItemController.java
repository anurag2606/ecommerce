package com.codewithanurag.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithanurag.ecommerce.dto.ItemDto;
import com.codewithanurag.ecommerce.exceptions.NotFoundException;
import com.codewithanurag.ecommerce.services.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemService itemService;

	@Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/addItem/image/{imageId}")
	public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto, @PathVariable Integer imageId)throws NotFoundException{
		return new ResponseEntity<>(itemService.createItem(itemDto, imageId), HttpStatus.CREATED);
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<ItemDto> getItemById(@PathVariable Integer itemId){
		return new ResponseEntity<>(itemService.getItemById(itemId), HttpStatus.OK);
	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ItemDto>> getAllItem(){
		return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
	
	}
	
	
}
