package com.splitwise.SplitWise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private Long amount;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private Group group;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;

//    @OneToMany(mappedBy = "expense")
//    private List<ExpenseUser> hadToPayUsers;
}
