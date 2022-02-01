package com.zkdlu.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public record ProductApi(ProductService productService) {

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
