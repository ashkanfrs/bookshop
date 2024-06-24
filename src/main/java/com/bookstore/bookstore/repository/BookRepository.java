package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
//    @Query("SELECT b FROM Book b WHERE b.name LIKE CONCAT('%', :name, '%')")
//    List<Book> findByNames(String name);
    List<Book> findByNameContains(String name);
}
