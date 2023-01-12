package com.codewithanurag.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithanurag.ecommerce.model.PurchaseItem;

@Repository
public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Integer> {

}
