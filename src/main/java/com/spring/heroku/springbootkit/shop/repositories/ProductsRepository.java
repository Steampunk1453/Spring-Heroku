package com.spring.heroku.springbootkit.shop.repositories;

import com.spring.heroku.springbootkit.shop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Integer> {
    Product findOneByName(String name);
}
