package com.acme.urproviderwebservices.security.domain.service;

import com.acme.urproviderwebservices.security.domain.model.entity.User;
import com.acme.urproviderwebservices.security.domain.service.communication.AuthenticateRequest;
import com.acme.urproviderwebservices.security.domain.service.communication.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    ResponseEntity<?> authenticate(AuthenticateRequest request);
    ResponseEntity<?> register(RegisterRequest request);

    List<User> getAll();
    User getById(Long id);
}
