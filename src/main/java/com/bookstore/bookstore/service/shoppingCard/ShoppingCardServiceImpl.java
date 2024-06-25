package com.bookstore.bookstore.service.shoppingCard;

import com.bookstore.bookstore.dto.request.ShoppingCardRequest;
import com.bookstore.bookstore.dto.response.ShoppingCardResponse;
import com.bookstore.bookstore.model.*;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.FactorRepository;
import com.bookstore.bookstore.repository.ShoppingCardRepository;
import com.bookstore.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService{
    private final FactorRepository factorRepository;
    private final UserRepository userRepository;
    private final ShoppingCardRepository shoppingCardRepository;
    private final BookRepository bookRepository;
    public ShoppingCardServiceImpl(FactorRepository factorRepository, UserRepository userRepository, ShoppingCardRepository shoppingCardRepository, BookRepository bookRepository){
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.shoppingCardRepository = shoppingCardRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    @Transactional
    public ShoppingCardResponse addShopingCard(ShoppingCardRequest shoppingCardRequest) {
        User user= userRepository.findById(shoppingCardRequest.getUserId())
                .orElseThrow(()->new RuntimeException("user.not.exist"));
        Book book = bookRepository.findById(shoppingCardRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("book.not.exist"));
        Optional<Factor> byId = factorRepository.findByUserAndPayed(user, Payed.UPAYED);
        Factor factor;
        factor = byId.orElseGet(() -> creatFactor(user));
        factorRepository.save(factor);
        ShoppingCard shoppingCard = creatShoppingCard(shoppingCardRequest ,book ,factor);
        return creatShoppingCardResponse( shoppingCardRepository.save(shoppingCard));

    }

    private ShoppingCardResponse creatShoppingCardResponse(ShoppingCard shoppingCard) {
        return ShoppingCardResponse.builder()
                .factorId(shoppingCard.getFactor().getId())
                .shoppingCard(shoppingCard.getId())
                .build();
    }

    private Factor creatFactor(User user) {
        return Factor.builder()
                .user(user)
                .payed(Payed.UPAYED)
                .build();
    }

    private ShoppingCard creatShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor) {
       return ShoppingCard.builder()
                .book(book)
                .factor(factor)
                .count(shoppingCardRequest.getCount())
                .build();
    }
}
