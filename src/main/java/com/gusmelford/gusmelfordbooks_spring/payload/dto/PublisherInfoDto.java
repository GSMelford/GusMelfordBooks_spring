package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherInfoDto {
    private UUID id;
    private String name;
    private String phone;
    private String address;
}
