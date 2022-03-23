package com.genspark.rest.videocardapi.domain.service;

import com.genspark.rest.videocardapi.domain.entity.Product;
import com.genspark.rest.videocardapi.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> get() {
        return productRepository.findAll();
    }

    @Override
    public Product find(Long id) {
        Optional<Product> p = productRepository.findById(id);
        Product product = null;
        if (p.isPresent()) {
            product = p.get();
        } else {
            throw new RuntimeException(" Product not found for id : " + id);
        }
        return product;
    }

    @Override
    public Product create(Product product) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        product.setDate(timestamp);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        product.setDate(timestamp);
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
