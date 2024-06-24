package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository extends JpaRepository<Factor, Long> {
}
