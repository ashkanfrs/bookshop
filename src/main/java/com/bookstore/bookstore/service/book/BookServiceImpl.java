package com.bookstore.bookstore.service.book;

import com.bookstore.bookstore.dto.request.BookRequest;
import com.bookstore.bookstore.dto.response.BookResponse;
import com.bookstore.bookstore.exeption.RuleException;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName =
                bookRepository.findByName(bookRequest.getName());
        if (byName.isPresent())
            throw new RuleException("book.is.already.exist");
        Book save = bookRepository.save(creatBook(bookRequest));
        return creatBookResponse(save);
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build());
    }

    @Override
    public List<BookResponse> findByName(String name) {
        return bookRepository.findByNameContains(name)
                .stream().map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
        return creatBookResponse(findByIdReturnBook(id));
    }

    @Override
    @Transactional
    public void deleted(Long id) {
        Book byId = findByIdReturnBook(id);
        bookRepository.delete(byId);
        //byId.setDeleted(LocalDateTime.now());
        // bookRepository.save(byId);
    }

    private Book creatBook(BookRequest bookRequest) {
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }

    private BookResponse creatBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();

    }

    private Book findByIdReturnBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuleException("book.not.found"));
    }
}
