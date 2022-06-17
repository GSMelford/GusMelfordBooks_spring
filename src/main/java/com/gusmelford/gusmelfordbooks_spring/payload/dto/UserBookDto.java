package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserBookDto {
    private String title;
    private Double price;
    private Date dateOfPurchase;
}
