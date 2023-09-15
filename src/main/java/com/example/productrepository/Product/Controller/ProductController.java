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
            return new Product("null", "null", 0);
        }
    }

    @PostMapping()
    public Product addProduct(@RequestBody NewProductDTO newProduct){
        return productService.addProduct(newProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable String id){
        try{
            productService.deleteProductBy(id);
            return "Product mit der Id: " + id + " ist gelöscht!";
        }catch(NoSuchElementException e){
            return "Das Product mit der Id: " + id + " existiert nicht und kann deshalb nicht gelöscht werden.";
        }
    }
}
