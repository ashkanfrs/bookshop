package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Long> {
}
