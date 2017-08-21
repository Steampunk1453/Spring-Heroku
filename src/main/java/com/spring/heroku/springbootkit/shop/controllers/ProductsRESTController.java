package com.spring.heroku.springbootkit.shop.controllers;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductsRESTController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {

        return new ResponseEntity<Product>(productsService.create(product), HttpStatus.CREATED);
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Product get(@PathVariable Integer id) {

        return productsService.get(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Product> getAll() {

        return productsService.getAll();
    }


}
