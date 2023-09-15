package com.example.productrepository.Product.Services;

import com.example.productrepository.Product.Entities.NewProductDTO;
import com.example.productrepository.Product.Entities.Product;
import com.example.productrepository.Product.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(NewProductDTO newProduct){
        Product product = new Product(UUID.randomUUID().toString(), newProduct.title(), newProduct.price());
        return productRepository.save(product);
    }

    public Product getProductBy(String id){
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteProductBy(String id) {
        try{
            Product deleteProduct = getProductBy(id);
            productRepository.delete(deleteProduct);
        }catch(NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
}
