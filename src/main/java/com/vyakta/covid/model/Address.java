package com.vyakta.covid.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Address implements Serializable {
    private static final long serialVersionUID = -2971464140477370957L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long address_id;
    private String address_label;
    private long user_id;
}

