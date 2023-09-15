package com.example.productrepository.Product.Controller;

import com.example.productrepository.Product.Entities.NewProductDTO;
import com.example.productrepository.Product.Entities.Product;
import com.example.productrepository.Product.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        try{
            return productService.getProductBy(id);
        } catch(NoSuchElementException e) {
            System.out.println("Fehler gefangen!" + e);
        }
        return null;
    }

    @PostMapping()
    public Product addProduct(@RequestBody NewProductDTO newProduct){
        return productService.addProduct(newProduct);
    }
}
