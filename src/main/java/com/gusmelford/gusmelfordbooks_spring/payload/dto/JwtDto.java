package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

@Data
public class JwtDto {
    private String accessToken;
    private String userRole;
    private String expiresIn;
    private String name;
}
