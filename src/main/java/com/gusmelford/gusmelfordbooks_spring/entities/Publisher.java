package com.gusmelford.gusmelfordbooks_spring.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();

    @OneToOne
    private Address address;

    @NotNull
    @Column(length = 30)
    private String name;

    @NotNull
    @Column(length = 20)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "publishers")
    private List<Book> books;
}
