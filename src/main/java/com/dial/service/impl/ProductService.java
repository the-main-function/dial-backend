package com.dial.service.impl;

import com.dial.entities.Product;
import com.dial.repo.ProductRepository;
import com.dial.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product fetchProduct(Integer productId){
        return productRepository.findById(productId).orElseThrow(()-> new RuntimeException());
    }
    public List<Product> fetchAllProducts(){
        return productRepository.findAll();
    }
}
