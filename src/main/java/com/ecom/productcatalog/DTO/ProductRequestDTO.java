package com.ecom.productcatalog.DTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {
    @NotBlank(message = "Product Name is Required.")
    private String name;

    private String description;

    @NotNull(message = "Product Image Missing.")
    private String image_name;

    @Min(value=1, message="Product B2B Price must be at least 1")
    private Double b2b_price;

    @Min(value=1, message="Product B2C Price must be at least 1")
    private Double b2c_price;

    @Min(value=1, message="Product Last Price must be at least 1")
    private Double last_price;

    private Long category_id;

    // getters
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public String getImage_name(){ return this.image_name; }
    public Double getB2b_price(){ return this.b2b_price; }
    public Double getB2c_price(){ return this.b2c_price; }
    public Double getLast_price(){ return this.last_price; }
    public Long getCategory_id(){ return category_id; }
}
