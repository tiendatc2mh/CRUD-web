package com.example.springboot_hibernate.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tbluser")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name="phone")
    private String phone;
}
