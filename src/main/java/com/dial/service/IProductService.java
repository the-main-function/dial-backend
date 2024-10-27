package com.dial.service;

import com.dial.entities.Product;

public interface IProductService {

    Product createProduct(Product product);
    Product fetchProduct(Integer productId);

}
