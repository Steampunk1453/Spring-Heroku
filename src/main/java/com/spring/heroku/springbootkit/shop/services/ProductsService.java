package com.spring.heroku.springbootkit.shop.services;

import com.spring.heroku.springbootkit.shop.model.Product;

public interface ProductsService {

    Product create(Product product);
    Product get(Integer id);
}
