package com.zkdlu.product;

import java.util.List;

public class SpyProductService implements ProductService {
    public List<Product> getProducts_returnValue;

    @Override
    public List<Product> getProducts() {
        return getProducts_returnValue;
    }
}
