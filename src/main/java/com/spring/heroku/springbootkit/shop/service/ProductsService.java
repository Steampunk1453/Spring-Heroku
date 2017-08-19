package com.spring.heroku.springbootkit.shop.service;

import com.spring.heroku.springbootkit.shop.model.Product;

public interface ProductsService {

    Product create(Product product);
    Product get(String id);
}
