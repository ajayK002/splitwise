package com.splitwise.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Group extends BaseModel{
    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> userList;

}
