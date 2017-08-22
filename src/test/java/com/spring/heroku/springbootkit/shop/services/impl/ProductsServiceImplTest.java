package com.spring.heroku.springbootkit.shop.services.impl;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.repositories.ProductsRepository;
import com.spring.heroku.springbootkit.shop.services.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceImplTest {

    @InjectMocks
    ProductsServiceImpl productsService;

    @Mock
    ProductsRepository productsRepository;

    @Test
    public void create() throws Exception {
        when(productsRepository.save(createProduct())).thenReturn(createProduct());
        Product product = productsService.create(createProduct());
        assertThat(product.getName(), is(equalTo("Arganen")));

    }

    @Test
    public void getIsNull() throws Exception {
        when(productsRepository.findOne((Integer) any())).thenReturn(null);
        Product product = productsService.get(new Integer(0));
        assertThat(product.getDesc(), is(nullValue()));
    }

    @Test
    public void get() throws Exception {
        when(productsRepository.findOne((Integer) any())).thenReturn(createProduct());
        Product product = productsService.get(new Integer(1));
        assertThat(product.getDesc(), is(equalTo("Docker power")));
    }

    @Test
    public void getAll() throws Exception {
        when(productsRepository.findAll()).thenReturn(createProductsList());
        List<Product> productsList = productsService.getAll();
        assertThat(productsList.size(), is(equalTo(1)));
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Arganen");
        product.setDesc("Docker power");
        product.setPrice(12.5);
        return product;
    }

    private List<Product> createProductsList() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(createProduct());
        return productsList;
    }

}