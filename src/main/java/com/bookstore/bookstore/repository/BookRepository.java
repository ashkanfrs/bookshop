package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);

    //    @Query("SELECT b FROM Book b WHERE b.name LIKE CONCAT('%', :name, '%')")
//    List<Book> findByNames(String name);
    List<Book> findByNameContains(String name);
}
