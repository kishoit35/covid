package com.vyakta.covid.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String user_name;
    private String role_type;
    private String user_type;
    private Date member_since;
    private String password;
    private String email_id;
    private String contact_no;
}


