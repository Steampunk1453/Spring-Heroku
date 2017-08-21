package com.spring.heroku.springbootkit.shop.controllers;

import com.spring.heroku.springbootkit.shop.model.Product;
import com.spring.heroku.springbootkit.shop.services.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductsRESTController.class)
public class ProductsRESTControllerTest {

    private static final String PRODUCT_JSON = "{ \"name\": \"Arganen\", \"desc\": \"Super cool console\", \"price\": 399.0 }";

    @MockBean
    private ProductsService productsService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenNewProductIsSent_ItWillBeCreatedWithUniqueId() throws Exception {

        Product product = new Product();
        product.setId(1234);
        product.setName("Arganen");

        when(productsService.create(any())).thenReturn(product);

        mvc.perform(post("/v1/products")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(PRODUCT_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value("Arganen"));
    }

    @Test
    public void whenAnExistingProductIsRequested_ItWillBeReturned() throws Exception {

        Product product = new Product();
        product.setId(1234);

        when(productsService.get(any())).thenReturn(product);

        mvc.perform(get("/v1/products/1234")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1234"));
    }
}

