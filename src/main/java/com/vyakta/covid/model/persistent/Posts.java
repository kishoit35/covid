package com.vyakta.covid.model.persistent;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "posts")
public class Posts implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
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
    private int addressId;
    private int addressType;


}

