package com.example.rabbit.controllers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationRequest implements Serializable {
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
}
