package com.dev42.cadastroprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev42.cadastroprodutos.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
