package com.vyakta.covid.service.signup;

import com.vyakta.covid.model.dto.UserRegistrationDto;

public interface UserRegistration {
    public long signUp(UserRegistrationDto user);
}
