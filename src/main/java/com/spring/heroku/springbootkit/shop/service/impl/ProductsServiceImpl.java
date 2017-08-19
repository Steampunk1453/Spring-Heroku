package com.spring.heroku.springbootkit.shop.service.impl;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.repository.ProductsRepository;
import com.spring.heroku.springbootkit.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Product create(Product product) {

        return productsRepository.save(product);
    }

    @Override
    public Product get(String id) {

        return productsRepository.findOne(id);
    }
}
