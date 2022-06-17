package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AuthorDto {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
}
