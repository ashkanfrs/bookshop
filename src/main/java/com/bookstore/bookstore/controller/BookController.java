package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.request.BookRequest;
import com.bookstore.bookstore.dto.response.BookResponse;
import com.bookstore.bookstore.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@RequestBody @Valid BookRequest book) {
        return ResponseEntity.ok(bookService.save(book));

    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookService.findAll(pageable));

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<BookResponse>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(
                bookService.findByName(name));

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleted(id);
        return ResponseEntity.ok().build();
    }
}
