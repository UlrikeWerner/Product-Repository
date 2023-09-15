package com.example.productrepository.Product.Repository;

import com.example.productrepository.Product.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
