package com.spring.heroku.springbootkit.shop.controller;

import com.spring.heroku.springbootkit.shop.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/products")
public class ProductsRESTController {

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {

        return new ResponseEntity<Product>(product.setId("1234"), HttpStatus.CREATED);
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Product get(@PathVariable String id) {

        return new Product().setId(id).setName("Arganen").setDesc("Spring Power").setPrice(12.5);
    }
}
