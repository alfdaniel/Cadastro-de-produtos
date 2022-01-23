package com.dev42.cadastroprodutos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dev42.cadastroprodutos.entities.Product;
import com.dev42.cadastroprodutos.repository.ProductRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public void run(String... args) throws Exception {
		
		Product prod1 = new Product(null, "Tubo 1/2 20mm", "tubo pvc agua 1/2 20mm pol", 
				3.00, 1, 60.00, 14.00, 80.00, null);
		
		Product prod2 = new Product(null, "Tubo 3/4 25mm", "tubo pvc agua 3/4 25mm pol", 
				3.00, 1, 60.00, 14.00, 80.00, null);
	
		productRepository.save(prod1);
		productRepository.save(prod2);
	
	}
}
