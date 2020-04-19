package com.vyakta.covid.model.persistent;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder(toBuilder = true)
public class Users implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String roleType;
    private String userType;
    private Date memberSince;
    private String password;
    private String emailId;
    private String contactNo;

    @OneToMany(cascade = {CascadeType.ALL})
    //@JoinColumn(name="userId")
    private List<Posts> postsList;

//    public Users() {
//    }
}


