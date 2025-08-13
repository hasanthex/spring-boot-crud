package com.ecom.productcatalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer pages;
    private String author;

    public void setTitle(String title){
        this.title = title;
    }

    public void setPages(Integer pages){
        this.pages = pages;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }

    public Integer getPages(){
        return this.pages;
    }

    public String getAuthor(){
        return this.author;
    }
}
