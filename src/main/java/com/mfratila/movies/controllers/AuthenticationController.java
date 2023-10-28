package com.mfratila.movies.controllers;

import com.mfratila.movies.models.ApplicationUser;
import com.mfratila.movies.models.LoginResponseDTO;
import com.mfratila.movies.models.RegistrationDTO;
import com.mfratila.movies.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    AuthenticationService authService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return authService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authService.loginUser(body.getUsername(), body.getPassword());
    }
}
