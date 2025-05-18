package com.codewithanurag.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithanurag.ecommerce.dto.CheckoutDto;
import com.codewithanurag.ecommerce.services.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private final CheckoutService checkoutService;

	@Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/add/item/{itemId}")
	public ResponseEntity<CheckoutDto> createCheckout(@RequestBody CheckoutDto checkoutDto, @PathVariable Integer itemId)throws Exception {
		return new ResponseEntity<>(checkoutService.createCheckoutItem(checkoutDto, itemId), HttpStatus.CREATED);

	}

	
	@DeleteMapping("/{checkoutId}")
	public void deleteCheckoutItem(@PathVariable Integer checkoutId) {
	this.checkoutService.deleteCkeckoutItem(checkoutId);
	}
}
