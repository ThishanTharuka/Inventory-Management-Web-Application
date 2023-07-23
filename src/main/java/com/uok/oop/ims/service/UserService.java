package com.uok.oop.ims.service;

import com.uok.oop.ims.dto.UserRegistrationDto;
import com.uok.oop.ims.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
