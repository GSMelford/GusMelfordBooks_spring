package com.gusmelford.gusmelfordbooks_spring.payload.request;

import lombok.Data;

@Data
public class UserLoginCredentials {
    private String email;
    private String password;
}
