package com.dev42.cadastroprodutos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev42.cadastroprodutos.repository.ProductRepository;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	
	@GetMapping
	public List findAll(){
		return repository.findAll();
	}
	

}
