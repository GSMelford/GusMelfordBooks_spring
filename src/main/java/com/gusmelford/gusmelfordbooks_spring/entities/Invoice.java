package com.gusmelford.gusmelfordbooks_spring.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();

    @ManyToOne
    private User user;

    private Double Amount = 1000d;
}
