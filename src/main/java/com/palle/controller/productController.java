package com.palle.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palle.entity.Product;
import com.palle.service.productService;

@RestController
@RequestMapping("/myapp")

public class productController {
	@Autowired
	private productService service;
//	1.REST API TO INSERT DATA
	@PostMapping("/insert")
	
	public Product insertProduct(@RequestBody Product p) {
		return service.insertdata(p);
	}
//	2.REST API TO READ ALL PRODUCTS DATA
	@GetMapping("/readall")
	public List<Product>readAll(){
		return service.readAllproduct();
		}
//	3.REST API TO READ ONE DATA
	@GetMapping("/readone/{id}")
	public Optional<Product>readOne(@PathVariable int id){
		Optional<Product>oneProduct=service.readOneProduct(id);
		return oneProduct;
	}
//	4.REST API TO UPDATE
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product newProduct) {
		Product updateproduct=service.update(id, newProduct);
		return updateproduct;
	}
//	5.REST API TO DELETE
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
		
	}
	
}
