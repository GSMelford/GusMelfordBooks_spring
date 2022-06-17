package com.gusmelford.gusmelfordbooks_spring.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtData {
    private String accessToken;
    private String userRole;
    private String expiresIn;
    private String name;
}
