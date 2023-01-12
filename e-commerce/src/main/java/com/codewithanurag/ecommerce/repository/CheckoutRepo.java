package com.codewithanurag.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithanurag.ecommerce.model.Checkout;

public interface CheckoutRepo extends JpaRepository<Checkout, Integer > {

}
