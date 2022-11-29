package com.example.isodemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name="Users")
public class IsoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

}
