package com.ecom.productcatalog.DTO;

public class ProductRequestDTO {
    private String name;
    private String description;
    private String image_name;
    private Double b2b_price;
    private Double b2c_price;
    private Double last_price;
    private Long category_id;

    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public String getImage_name(){ return this.image_name; }
    public Double getB2b_price(){ return this.b2b_price; }
    public Double getB2c_price(){ return this.b2c_price; }
    public Double getLast_price(){ return this.last_price; }
    public Long getCategory_id(){ return category_id; }
}
