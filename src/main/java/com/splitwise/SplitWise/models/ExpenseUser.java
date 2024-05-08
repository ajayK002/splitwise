package com.splitwise.SplitWise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExpenseUser extends BaseModel{

    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private Long amount;

    @Enumerated(value = EnumType.STRING)
    private ExpenseUserType expenseUserType;
}
