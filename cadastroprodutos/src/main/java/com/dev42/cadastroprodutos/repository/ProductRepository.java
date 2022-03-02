package com.dev42.cadastroprodutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev42.cadastroprodutos.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select * from product", nativeQuery = true)
	List<Product> findAllNativeQuery();
	
	@Query(value = "select * from product i where i.id= ?", nativeQuery = true)
	List<Product> findByIdNativeQuery(long id);
	
	@Modifying
	@Query(value = "delete from product i where i.id= ?", nativeQuery= true )
	void deleteByIdNativeQuery(@Param("id") long id);
	
	@Query(value = "SELECT * FROM product e WHERE e.name like %:name%", nativeQuery = true)
	List<Product> findAllByNameNativeQuery(@Param("name") String name);
	
	
}
