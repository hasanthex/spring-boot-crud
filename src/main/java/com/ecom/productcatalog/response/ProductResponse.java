package com.ecom.productcatalog.response;

public class ProductResponse {
    private String product_name;
    private String product_image;
    private Double price;

    public ProductResponse(String product_name, String product_image, Double price){
        this.product_name = product_name;
        this.product_image= product_image;
        this.price = price;
    }
}
