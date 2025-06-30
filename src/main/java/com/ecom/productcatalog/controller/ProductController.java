package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.DTO.ProductRequestDTO;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        List<Product> products = this.productService.getAllProducts();
        System.out.println("Fetch products "+products);
        return products;
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable Long categoryId){
        return this.productService.getProductByCategory(categoryId);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO dto){
        Product savedProduct = this.productService.saveProduct(dto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
