package com.spring.heroku.springbootkit.shop.services.impl;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.services.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceImplTest {

    @Mock
    ProductsService productsService;

    @Test
    public void create() throws Exception {
        when(productsService.create(any())).thenReturn(createProduct());
        assertThat(productsService.create(createProduct()).getName(), is(equalTo("Arganen")));

    }

    @Test
    public void get() throws Exception {
        when(productsService.get(any())).thenReturn(createProduct());
        assertThat(productsService.get(new Integer(1)).getDesc(), is(equalTo("Docker power")));
    }

    @Test
    public void getAll() throws Exception {
        when(productsService.getAll()).thenReturn(createProductsList());
        assertThat(productsService.getAll().size(), is(equalTo(1)));
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