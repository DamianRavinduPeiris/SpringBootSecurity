package com.damian.security.service;

import com.damian.security.config.JWTService;
import com.damian.security.model.UserDetails;
import com.damian.security.repo.UserRepo;
import com.damian.security.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private Response response;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;

    public Response register(UserDetails userDetails) {
        String password = passwordEncoder.encode(userDetails.getPassword());
        userDetails.setPw(password);
        userRepo.save(userDetails);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("User successfully registered and JWT Successfully generated!");
        response.setData("JWT : "+jwtService.generateToken(userDetails));
        return response;
    }


}
