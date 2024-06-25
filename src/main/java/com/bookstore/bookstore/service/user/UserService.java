package com.bookstore.bookstore.service.user;

import com.bookstore.bookstore.dto.request.UserLoginRequest;
import com.bookstore.bookstore.dto.request.UserRequest;
import com.bookstore.bookstore.dto.response.UserResponse;
import com.bookstore.bookstore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponse save(UserRequest userRequest);

    void login(UserLoginRequest userLoginRequest);

    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);
}
