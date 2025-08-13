package com.ecom.productcatalog.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ecom.productcatalog.DTO.ProductRequestDTO;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.response.ProductResponse;
import com.ecom.productcatalog.service.ProductService;

import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final String UPLOAD_DIR= "uploads/";
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
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequestDTO dto){
        Product savedProduct = this.productService.saveProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PostMapping("/update")
    public Map<String, Object> updateProduct(){
        return Map.of(
                "status", "ok",
                "message", "Service is running.",
                "timestamp", System.currentTimeMillis(),
                "routes", List.of("login", "report", "manage")
        );
    }

    @PostMapping("/product-image-upload")
    public Map<String, Object> uploadImage(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return Map.of(
                    "status", "fail",
                    "message", "Image Missing",
                    "timestamp", System.currentTimeMillis()
            );
        }

        try {
            // Ensure directory exists
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            // save the file
            String filename = UUID.randomUUID() +"_"+ file.getOriginalFilename();
            Path filepath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);

            return Map.of(
                    "status", "ok",
                    "message", "Product Image Upload Successfully.",
                    "timestamp", System.currentTimeMillis()
            );

        } catch (Exception e) {
            return Map.of(
                    "status", "fail",
                    "message", "Unable to upload Product Image.",
                    "timestamp", System.currentTimeMillis()
            );
        }
    }
}
