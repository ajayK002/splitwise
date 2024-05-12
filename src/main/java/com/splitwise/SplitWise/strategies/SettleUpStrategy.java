package com.splitwise.SplitWise.strategies;

import com.splitwise.SplitWise.models.Expense;
import com.splitwise.SplitWise.services.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
