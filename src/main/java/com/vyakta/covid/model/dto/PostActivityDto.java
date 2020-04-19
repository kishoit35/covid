package com.vyakta.covid.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostActivityDto {
    private String postDesc;
    private Date postCreateDate;
    private Date postRequestDate;
    private String type;
    private String subType;
    private int quantity;
    private int userId;
    private String status;
    private Date postEndDate;
    private String recurring;
    private boolean isRegisteredAddress;
    private int addressId;
    private int addressType;
    private String addressLabel;
    private String mailId;
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
