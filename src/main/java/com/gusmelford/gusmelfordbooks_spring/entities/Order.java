package com.gusmelford.gusmelfordbooks_spring.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "system_order")
public class Order {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();

    @ManyToOne
    private User customer;

    private Double price;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "orders")
    public List<Book> books;
}
