package com.bookstore.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BookResponse {
    private final Long id;
    private final String name;
    private final double price;
}
