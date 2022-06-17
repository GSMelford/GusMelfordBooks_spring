package com.gusmelford.gusmelfordbooks_spring.payload.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PublisherData {
    private UUID id;
    private String name;
    private String phone;
    private UUID addressId;
}
