package com.splitwise.SplitWise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private Long amount;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    @OneToMany
    private List<ExpenseUser> paidByUsers;

    @OneToMany
    private List<ExpenseUser> hadToPayUsers;
}
