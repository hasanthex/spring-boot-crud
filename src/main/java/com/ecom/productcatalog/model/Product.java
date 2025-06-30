package com.ecom.productcatalog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private String description;
    private String images;
    private Double b2b_price;
    private Double b2c_price;
    private Double last_price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable= false)
    private Category category;

    // setters
    public void setName(String name){ this.product_name = name; }
    public void setDescription(String description){ this.description = description; }
    public void setImage(String image){ this.images = image; }
    public void setB2b_price(Double b2b_price){ this.b2b_price = b2b_price; }
    public void setB2c_price(Double b2c_price){ this.b2c_price = b2c_price; }
    public void setLast_price(Double last_price){ this.last_price = last_price; }
    public void setCategory(Category category){ this.category = category; }
}
