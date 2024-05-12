package com.splitwise.SplitWise.services;

import com.splitwise.SplitWise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private Long amount;
    private User paidBy;
    private User paidTo;
}
