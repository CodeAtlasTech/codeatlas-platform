package com.codeatlas.backend.service;

import com.codeatlas.backend.entity.User;
import com.codeatlas.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveOrGetUser(String email, String name, String provider) {

        return userRepository.findByEmail(email)
                .orElseGet(() ->
                        userRepository.save(
                                User.builder()
                                        .email(email)
                                        .name(name)
                                        .provider(provider)
                                        .role("USER")
                                        .build()
                        )
                );
    }
}
