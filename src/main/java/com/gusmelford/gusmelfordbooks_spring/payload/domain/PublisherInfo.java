package com.gusmelford.gusmelfordbooks_spring.payload.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PublisherInfo {
    private UUID id;
    private String name;
    private String phone;
    private String address;

    public PublisherInfo(UUID id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
