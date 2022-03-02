package com.dev42.cadastroprodutos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev42.cadastroprodutos.entities.Product;
import com.dev42.cadastroprodutos.repository.ProductRepository;

@RestController
@RequestMapping({"/product"})
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	//http://localhost:8083/product
	@PostMapping
	public Product create(@RequestBody Product product){
		return repository.save(product);
	}
	
	//http://localhost:8083/product/id
	@PutMapping(value = "{id}")
	public ResponseEntity update(@PathVariable long id, @RequestBody Product product){
		return repository.findById(id)
				.map(record -> {
					record.setCategory(product.getCategory());
					record.setDescription(product.getDescription());
					record.setFinalPrice(product.getFinalPrice());
					record.setFinalPrice(product.getFinalPrice());
					record.setFractionPrice(product.getFractionPrice());
					record.setName(product.getName());
					record.setImgUrl(product.getImgUrl());
					record.setQuantity(product.getQuantity());
					Product prod = repository.save(record);
					return ResponseEntity.ok().body(prod);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	//Métodos Utilizando native query
	
	//http://localhost:8083/product/listquery
	@GetMapping({"/listquery"})
	public List findAllQuery(){
		return repository.findAllNativeQuery();
	}
	
	//http://localhost:8083/product/id
	@GetMapping(value = "{id}")
	public List findAllByIdQuery(@PathVariable long id){
		return repository.findByIdNativeQuery(id);
	}
	
	//http://localhost:8083/product/id
	@DeleteMapping(value = {"id"})
	public void deleteByIdQuery(@PathVariable long id){
		repository.deleteByIdNativeQuery(id);
	}
	
	//http://localhost:8083/product/name?name=name *esse ultimo name é o parâmetro
	@GetMapping(value = "/name")
	public List<Product> findAllByNameQuery(@RequestParam("name")String name){
		return repository.findAllByNameNativeQuery(name);
	}
		
}
