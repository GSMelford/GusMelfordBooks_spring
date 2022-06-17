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
@Table(name = "author")
public class Author {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();

    @NotNull
    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String middleName;

    @NotNull
    @Column(length = 30)
    private String lastName;

    private Date dateOfBirth;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Book> books;
}
