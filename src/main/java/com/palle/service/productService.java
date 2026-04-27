package com.palle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palle.entity.Product;
import com.palle.repository.ProductRepository;

@Service
public class productService {

    @Autowired
    private ProductRepository repository;

    // 1. INSERT DATA
    public Product insertdata(Product p) {
        return repository.save(p);
    }

    // 2. READ ALL DATA
    public List<Product> readAllproduct() {
        return repository.findAll();
    }
//    3.READ ONE DATA
    public Optional<Product>readOneProduct(int id){
    	Optional<Product>byId=repository.findById(id);
    	return byId;
    }
//    4.UPDATE DATA PRODUCT
    public Product update(int id,Product newproduct) {
    	Optional<Product>byId=repository.findById(id);
    	Product existingproduct=null;
    			if(byId.isPresent()){
    		existingproduct=byId.get();
//    		UPDATE EXISTIING DATA
    		existingproduct.setProductName(newproduct.getProductName());
    		existingproduct.setProductPrice(newproduct.getProductPrice());
    		existingproduct.setProductQuantity(newproduct.getProductQuantity());
    		repository.save(existingproduct);
    		
    	}
    			return existingproduct;
    }
//    5.DELETE THE PRODUCT
    public String deleteProduct(int id) {
    	Optional<Product>Optional=repository.findById(id);
    	if(Optional.isPresent()) {
    		Product product =Optional.get();
    		repository.delete(product);
    		return "Product with id: "+id+"does not existed";
    		
    	}
    	return "Product with id: "+id+"does not existed";
    }
    
}