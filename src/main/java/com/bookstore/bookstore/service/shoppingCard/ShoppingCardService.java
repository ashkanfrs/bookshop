package com.bookstore.bookstore.service.shoppingCard;

import com.bookstore.bookstore.dto.request.ShoppingCardRequest;
import com.bookstore.bookstore.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {

    ShoppingCardResponse addShopingCard(ShoppingCardRequest shoppingCardRequest);
}
