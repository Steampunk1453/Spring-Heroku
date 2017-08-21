package com.spring.heroku.springbootkit.shop.repositories;

import com.spring.heroku.springbootkit.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
