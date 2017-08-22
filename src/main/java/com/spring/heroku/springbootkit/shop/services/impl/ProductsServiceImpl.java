package com.spring.heroku.springbootkit.shop.services.impl;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.repositories.ProductsRepository;
import com.spring.heroku.springbootkit.shop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Product create(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public Product get(Integer id) {
        if(id != 0) {
            return productsRepository.findOne(id);
        }
        return new Product();
    }

    @Override
    public List<Product> getAll() {
        return productsRepository.findAll();
    }
}
