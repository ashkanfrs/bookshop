package com.bookstore.bookstore.service.user;

import com.bookstore.bookstore.dto.request.UserRequest;
import com.bookstore.bookstore.dto.response.UserResponse;
import com.bookstore.bookstore.exeption.RuleException;
import com.bookstore.bookstore.model.User;
import com.bookstore.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername =
                userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent())
            throw new RuleException("Username.is.exist");
        return createUserResponse(userRepository.save(createUser(userRequest)));

    }

    private UserResponse createUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    private User createUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();
    }
}
