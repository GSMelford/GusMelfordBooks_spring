package com.gusmelford.gusmelfordbooks_spring.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="role_permission")
public class Permission {
    @Id
    public UUID id = UUID.randomUUID();
    public Date createdOn = new Date();
    public Date modifiedOn = new Date();
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
