package com.spring.heroku.springbootkit.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true)
public class ProductDto {

    private String id;
    private String name;
    private String desc;
    private Double price;
}