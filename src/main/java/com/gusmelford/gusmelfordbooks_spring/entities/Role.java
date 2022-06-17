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
@Table(name = "system_role")
public class Role {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<Permission> permissions;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;
}
