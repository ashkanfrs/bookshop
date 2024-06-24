package com.bookstore.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookRequest {

    @NotNull(message = "{book.name.can.not.be.null}")
    @NotBlank(message = "{book.name.can.not.be.blank")
    private final String name;
    @NotNull(message = "{price.can.not.be.null}")
//    @NotBlank(message = "{price.can.not.be.blank}")
    @Min(value = 0, message = "{The.price.cannot.be.below.0.euros}")
    private final double price;
}
