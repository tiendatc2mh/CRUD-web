package com.example.springboot_hibernate.Model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "tblemployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

}
