package com.gusmelford.gusmelfordbooks_spring.payload.request;

import lombok.Data;

@Data
public class UserRegistrationData {
    public String firstName;
    public String middleName;
    public String lastName;
    public String phone;
    public String email;
    public String password;
}
