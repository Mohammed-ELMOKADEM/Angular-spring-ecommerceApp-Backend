package com.ecom.ecommerceApp.services;

import com.ecom.ecommerceApp.models.User;
import com.ecom.ecommerceApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow();
    }
}
