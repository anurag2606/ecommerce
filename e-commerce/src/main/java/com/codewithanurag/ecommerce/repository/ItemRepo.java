package com.codewithanurag.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithanurag.ecommerce.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	public Item findByItem(String item);

	
}
