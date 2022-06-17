package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {
    private UUID Id;
    private String country;
    private String city;
    private String street;
}
