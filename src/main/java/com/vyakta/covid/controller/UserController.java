package com.vyakta.covid.controller;

import com.vyakta.covid.repository.AddressRepository;
import com.vyakta.covid.repository.PostsRepository;
import com.vyakta.covid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private AddressRepository addressRepository;
}
