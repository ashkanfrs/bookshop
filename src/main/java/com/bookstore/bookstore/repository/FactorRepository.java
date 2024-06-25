package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Factor;
import com.bookstore.bookstore.model.Payed;
import com.bookstore.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor, Long> {
    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
