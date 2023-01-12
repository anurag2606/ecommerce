package com.codewithanurag.ecommerce.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithanurag.ecommerce.dto.PurchaseItemDto;
import com.codewithanurag.ecommerce.exceptions.ResourceNotFoundException;
import com.codewithanurag.ecommerce.model.Checkout;
import com.codewithanurag.ecommerce.model.PurchaseItem;
import com.codewithanurag.ecommerce.repository.CheckoutRepo;
import com.codewithanurag.ecommerce.repository.PurchaseItemRepo;
import com.codewithanurag.ecommerce.services.PurchaseItemService;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {

	@Autowired
	private PurchaseItemRepo purchaseItemRepo;

	@Autowired
	private CheckoutRepo checkoutRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PurchaseItemDto getPurchaseItem( Integer checkoutId) {

		Checkout checkout = this.checkoutRepo.findById(checkoutId)
				.orElseThrow(() -> new ResourceNotFoundException("Checkout", "Id", checkoutId));

	//PurchaseItem purchaseItem = dtoToPurchaseItem(purchaseItemDto);
		PurchaseItem purchaseItem = new PurchaseItem();
		purchaseItem.setCheckout(checkout);
		PurchaseItem savedPurchaseItem = this.purchaseItemRepo.save(purchaseItem);
		//this.checkoutRepo.deleteById(checkoutId);

		return purchaseItemToDto(savedPurchaseItem);
	}

	public PurchaseItem dtoToPurchaseItem(PurchaseItemDto purchaseItemDto) {
		PurchaseItem purchaseItem = this.modelMapper.map(purchaseItemDto, PurchaseItem.class);
		return purchaseItem;
	}

	public PurchaseItemDto purchaseItemToDto(PurchaseItem purchaseItem) {
		PurchaseItemDto purchaseItemDto = this.modelMapper.map(purchaseItem, PurchaseItemDto.class);
		return purchaseItemDto;
	}
}
