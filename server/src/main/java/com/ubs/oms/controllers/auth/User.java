package com.ubs.oms.controllers.auth;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String company;
}
