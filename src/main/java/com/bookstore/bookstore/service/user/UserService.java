package com.bookstore.bookstore.service.user;

import com.bookstore.bookstore.dto.request.UserRequest;
import com.bookstore.bookstore.dto.response.UserResponse;

public interface UserService {
    UserResponse save(UserRequest userRequest);
}
