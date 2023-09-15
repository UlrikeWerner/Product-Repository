package com.example.productrepository.Product.Services;

import com.example.productrepository.Product.Entities.Product;
import com.example.productrepository.Product.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
