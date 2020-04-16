package com.vyakta.covid.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Posts implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;
    private String post_desc;
    private Date post_create_date;
    private Date post_request_date;
    private String type;
    private String sub_type;
    private int quantity;
    private long user_id;
    private String status;
    private Date post_end_date;
    private String recurring;
    private int address_id;
    private int address_type;
}

