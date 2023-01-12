package com.codewithanurag.ecommerce.services;

import com.codewithanurag.ecommerce.dto.PurchaseItemDto;

public interface PurchaseItemService {

	PurchaseItemDto getPurchaseItem(Integer checkoutId);
}
