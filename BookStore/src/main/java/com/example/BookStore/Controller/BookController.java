package com.example.BookStore.Controller;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Book> GetAll() {
        return bookService.getAll();
    }
    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id)
    {
        return bookService.get(id);
    }
    @PostMapping("/books")
    public Book create(@RequestBody
                       Book book)
    {
        bookService.add(book);
        return book;
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int
                               id)
    {
        bookService.remove(id);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
            Book updatedBook = bookService.update(id, book);
            return ResponseEntity.ok(updatedBook);
    }

}

