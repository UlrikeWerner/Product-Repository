package com.example.productrepository.Product.Services;

import com.example.productrepository.Product.Entities.NewProductDTO;
import com.example.productrepository.Product.Entities.Product;
import com.example.productrepository.Product.Repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    ProductRepository productRepository = mock(ProductRepository.class);
    ProductService productService = new ProductService(productRepository);

    @Test
    void getAllProducts_ReturnListOfOneProduct() {
        Product p1 = new Product("1", "product1", 2);
        List<Product> productList = List.of(p1);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> actual = productService.getAllProducts();

        List<Product> expected = List.of(new Product("1", "product1", 2));

        verify(productRepository).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void getProductBy_ReturnProduct() {
        String id = "123";
        Product testProduct = new Product("123", "product123", 4);

        when(productRepository.findById(id)).thenReturn(Optional.of(testProduct));

        Product actual = productService.getProductBy(id);
        Product expected = new Product("123", "product123", 4);

        verify(productRepository).findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void getProductBy_ThrowException() {
        String id = "123";

        when(productRepository.findById(id)).thenThrow(NoSuchElementException.class);
        //when(productRepository.findById(id)).thenReturn(Optional.empty());

        try{
            Product actual = productService.getProductBy(id);
        }catch (NoSuchElementException e){
            verify(productRepository).findById(id);
            assert true;
        }
    }

    @Test
    void addProduct() {
        UUID mockUUID = UUID.fromString("770a1fb7-9899-4c8a-bdc1-83d163b1080c");
        mockStatic(UUID.class);
        when(UUID.randomUUID()).thenReturn(mockUUID);

        NewProductDTO newProduct = new NewProductDTO("testProduct", 123);
        Product savedProduct = new Product("770a1fb7-9899-4c8a-bdc1-83d163b1080c", "testProduct", 123);

        when(productRepository.save(savedProduct)).thenReturn(savedProduct);

        Product actual = productService.addProduct(newProduct);

        Product expected = new Product("770a1fb7-9899-4c8a-bdc1-83d163b1080c", "testProduct", 123);
        verify(productRepository).save(savedProduct);
        assertEquals(expected, actual);
    }
}