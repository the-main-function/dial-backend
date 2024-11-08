package com.dial.service;

import com.dial.entities.Product;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);
    Product fetchProduct(Integer productId);

    List<Product> fetchAllProducts();

}
