package com.gusmelford.gusmelfordbooks_spring.payload.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserBook {
    private String title;
    private Double price;
    private Date dateOfPurchase;

    public UserBook(String title, Double price, Date dateOfPurchase) {
        this.title = title;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }
}
