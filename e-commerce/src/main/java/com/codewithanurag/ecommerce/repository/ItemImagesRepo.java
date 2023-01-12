package com.codewithanurag.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithanurag.ecommerce.model.Images;

@Repository
public interface ItemImagesRepo extends JpaRepository<Images, Integer >{

}
