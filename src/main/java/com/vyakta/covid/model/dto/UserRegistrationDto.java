package com.vyakta.covid.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder(toBuilder = true)
public class UserRegistrationDto {
    //private long user_id;
    private String userName;
    private String roleType;
    private String userType;
    private Date memberSince;
    private String password;
    private String emailId;
    private String contactNo;
    //private long address_id;
    private String addressLabel;
    //private long user_id;
    private String addLine1;
    private String addLine2;
    private String addLine3;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String location;
    private String landMark;
}
