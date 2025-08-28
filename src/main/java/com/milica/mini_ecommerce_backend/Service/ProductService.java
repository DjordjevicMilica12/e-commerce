package com.milica.mini_ecommerce_backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.milica.mini_ecommerce_backend.Repository.ProductRepository;

import com.milica.mini_ecommerce_backend.Model.Product;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

}
