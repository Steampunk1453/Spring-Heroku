package com.spring.heroku.springbootkit.shop.repository;

import com.spring.heroku.springbootkit.shop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product, String> {

}