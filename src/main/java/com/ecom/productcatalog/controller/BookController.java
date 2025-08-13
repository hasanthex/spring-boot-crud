package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.model.Book;
import com.ecom.productcatalog.repository.BookRepository;
import com.ecom.productcatalog.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("store")
    public Book storeBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PostMapping("get-book-by-id")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id).orElse(null);
    }
}
