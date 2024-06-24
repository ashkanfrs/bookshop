package com.bookstore.bookstore.service.book;

import com.bookstore.bookstore.dto.request.BookRequest;
import com.bookstore.bookstore.dto.response.BookResponse;
import com.bookstore.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookResponse save(BookRequest bookRequest);

    Page<BookResponse> findAll(Pageable pageable) ;

    List<BookResponse> findByName(String name);

    BookResponse findById(Long id);
}
