package com.gusmelford.gusmelfordbooks_spring.services.interfaces;

import com.gusmelford.gusmelfordbooks_spring.entities.User;
import com.gusmelford.gusmelfordbooks_spring.payload.request.JwtData;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserLoginCredentials;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserRegistrationData;

public interface AuthService {
    User register(UserRegistrationData userRegistrationData);
    JwtData login(UserLoginCredentials loginCredentials);
    User registerAdmin(UserRegistrationData registerRequest);
}
