package com.vyakta.covid.controller;

import com.vyakta.covid.model.dto.UserRegistrationDto;
import com.vyakta.covid.repository.AddressRepository;
import com.vyakta.covid.repository.PostsRepository;
import com.vyakta.covid.repository.UsersRepository;
import com.vyakta.covid.service.signup.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRegistration userRegistrationService;

    @PostMapping(path="/createUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRegistrationDto signUpUser(@RequestBody UserRegistrationDto user) {
        userRegistrationService.signUp(user);
        return user;
    }
}
