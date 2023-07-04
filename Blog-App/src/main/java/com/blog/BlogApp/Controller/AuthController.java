package com.blog.BlogApp.Controller;

import com.blog.BlogApp.dto.LoginRequest;
import com.blog.BlogApp.dto.RegisterRequest;
import com.blog.BlogApp.exception.SpringBlogException;
import com.blog.BlogApp.service.AuthService;
import com.blog.BlogApp.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
     @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest)
    {
     authService.signup(registerRequest);
    return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) throws SpringBlogException {
   return authService.login(loginRequest);
    }


}
