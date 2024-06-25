package com.bookstore.bookstore.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShoppingCardRequest {
    @NotNull(message = "{user.id.cant.be.null}")
    //@NotBlank(message = "{user.id.cant.be.blank}")
    private Long userId;
    @NotNull(message = "{book.id.cant.be.null}")
    // @NotBlank(message = "{book.id.cant.be.blank}")
    private Long bookId;
    @NotNull(message = "{count.cant.be.null}")
    //@NotBlank(message = "{count.cant.be.blank}")
    @Min(value = 1, message = "{count.is.not.valid}")
    private Integer count;
}
