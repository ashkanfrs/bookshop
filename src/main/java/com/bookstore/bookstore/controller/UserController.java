package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.request.UserLoginRequest;
import com.bookstore.bookstore.dto.request.UserRequest;
import com.bookstore.bookstore.dto.response.UserResponse;
import com.bookstore.bookstore.model.User;
import com.bookstore.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        userService.login(userLoginRequest);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/enable/{id}/{enable}")
    public ResponseEntity<?> changeEnableUser(@PathVariable Boolean enable, @PathVariable Long id) {
        userService.changeEnable(enable, id);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUser(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));

    }


}
