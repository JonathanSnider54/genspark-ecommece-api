package com.genspark.rest.videocardapi.domain.service;

import com.genspark.rest.videocardapi.domain.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> get();
    Product find(Long id);
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
}
