package com.codewithanurag.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithanurag.ecommerce.dto.PurchaseItemDto;
import com.codewithanurag.ecommerce.services.PurchaseItemService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseItemController {
	
	@Autowired
	private PurchaseItemService purchaseItemService;

    public PurchaseItemController(PurchaseItemService purchaseItemService) {
        this.purchaseItemService = purchaseItemService;
    }

    @GetMapping("/{checkoutId}")
	public ResponseEntity<PurchaseItemDto> getItemById(@PathVariable Integer checkoutId){
		done();
		System.out.print(purchaseItemService);
		return new ResponseEntity<>(purchaseItemService.getPurchaseItem(checkoutId), HttpStatus.OK);
	}

	private void done() {
		purchaseItemService.getPurchaseItem(0);
		purchaseItemService.hashCode();
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
		System.out.println("This is for testing");
	}
}


