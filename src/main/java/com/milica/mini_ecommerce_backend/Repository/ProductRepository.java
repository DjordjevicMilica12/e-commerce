package com.milica.mini_ecommerce_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milica.mini_ecommerce_backend.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
