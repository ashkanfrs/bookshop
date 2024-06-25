package com.bookstore.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class ShoppingCardResponse {
    private final Long shoppingCard;
    private final Long factorId;

}
