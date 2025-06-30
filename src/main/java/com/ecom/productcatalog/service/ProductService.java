package com.ecom.productcatalog.service;

import com.ecom.productcatalog.DTO.ProductRequestDTO;
import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId){
        return this.productRepository.findByCategoryId(categoryId);
    }

    public Product saveProduct(ProductRequestDTO dto){
        Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage_name());
        product.setB2b_price(dto.getB2b_price());
        product.setB2c_price(dto.getB2c_price());
        product.setLast_price(dto.getLast_price());
        product.setCategory(category);

        return productRepository.save(product);
    }

}
