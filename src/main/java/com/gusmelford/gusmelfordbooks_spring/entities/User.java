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
@Table(name = "system_user")
public class User {
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

    @Column(length = 20, unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
