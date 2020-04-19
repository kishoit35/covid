package com.vyakta.covid.model.persistent;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
@Builder(toBuilder = true)
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String addressLabel;
    private int userId;
    private String mailId;
    private String addLine1;
    private String addLine2;
    private String addLine3;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String location;
    private String landmark;

//    public Address() {
//    }
}

