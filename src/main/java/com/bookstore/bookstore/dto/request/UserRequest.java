package com.bookstore.bookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "{username.can.not.be.null}")
    @NotBlank(message = "{username.can.not.be.blank}")
    private final String username;
    @NotNull(message = "{password.can.not.be.null}")
    @NotBlank(message = "{password.can.not.be.blank}")
    private final String password;
}
