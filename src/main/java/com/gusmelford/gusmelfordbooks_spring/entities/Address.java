package com.gusmelford.gusmelfordbooks_spring.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();
    private String country;
    private String city;

    @NotNull
    @Column(unique = true)
    private String street;
}
