package com.codewithanurag.ecommerce.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithanurag.ecommerce.dto.CheckoutDto;
import com.codewithanurag.ecommerce.exceptions.ResourceNotFoundException;
import com.codewithanurag.ecommerce.model.Checkout;
import com.codewithanurag.ecommerce.model.Item;
import com.codewithanurag.ecommerce.repository.CheckoutRepo;
import com.codewithanurag.ecommerce.repository.ItemRepo;
import com.codewithanurag.ecommerce.services.CheckoutService;
import com.codewithanurag.ecommerce.exceptions.NotFoundException;
@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	@Autowired
	private CheckoutRepo checkoutRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CheckoutDto createCheckoutItem(CheckoutDto checkoutDto, Integer itemId) throws NotFoundException{
		Checkout saveCheckout = new Checkout();
	Item item = this.itemRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item", "Id", itemId));
		//Item item = this.itemRepo.findByItem(name);
		Checkout checkout = dtoToCheckout(checkoutDto);
		checkout.setItem(item);
		if (checkout.getCartQuantity()<= item.getQuantity() && checkout.getCartQuantity()>0 ) {
			 saveCheckout = this.checkoutRepo.save(checkout);
			//return checkoutToDto(saveCheckout);
		}
		else {
			throw new NotFoundException("Checkout cart quantity is grater than item cart quantity or It is less than 1");
		}
		return checkoutToDto(saveCheckout);
	}
	

	@Override
	public void deleteCkeckoutItem(Integer checkoutId) {
	Checkout checkout =	checkoutRepo.findById(checkoutId).orElseThrow(() -> new ResourceNotFoundException("Checkout item", "Id", checkoutId));
		checkoutRepo.delete(checkout);
	}
	
	
	/*
	 * convert dto to model 
	 * and vice versa
	 */
	
	public CheckoutDto checkoutToDto(Checkout checkout) {
		CheckoutDto checkoutDto = this.modelMapper.map(checkout, CheckoutDto.class);
		return checkoutDto;
	}
	
	public Checkout dtoToCheckout(CheckoutDto checkoutDto) {
		Checkout checkout = this.modelMapper.map(checkoutDto, Checkout.class);
		return checkout;
	}




}
