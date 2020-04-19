package com.vyakta.covid.service.signup;

import com.vyakta.covid.model.dto.UserRegistrationDto;
import com.vyakta.covid.model.persistent.Address;
import com.vyakta.covid.model.persistent.Users;
import com.vyakta.covid.repository.AddressRepository;
import com.vyakta.covid.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRegistrationImpl implements UserRegistration {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public long signUp(UserRegistrationDto user) {

        Users dbUser = Users.builder()
                .userName(user.getUserName())
                .contactNo(user.getContactNo())
                .emailId(user.getEmailId())
                .memberSince(user.getMemberSince())
                .password(user.getPassword())
                .userType("U")
                .build();
        Users users =  usersRepository.save(dbUser);
        System.out.println("User inserted...");
        Address address = Address.builder()
                .addressId(users.getUserId())
                .addLine1(user.getAddLine1())
                .addLine2(user.getAddLine2())
                .addLine3(user.getAddLine3())
                .city(user.getCity())
                .country(user.getCountry())
                .landmark(user.getLandMark())
                .location(user.getLocation())
                .mailId(user.getEmailId())
                .pincode(user.getPincode())
                .state(user.getState())
                .addressLabel("S")
                .userId(users.getUserId())
                .build();

        Address addressObj = addressRepository.save(address);
        System.out.println("Address inserted...");

        return users.getUserId();
    }
}
