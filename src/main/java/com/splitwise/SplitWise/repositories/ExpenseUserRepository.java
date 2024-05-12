package com.splitwise.SplitWise.repositories;

import com.splitwise.SplitWise.models.Expense;
import com.splitwise.SplitWise.models.ExpenseUser;
import com.splitwise.SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findAllByUser(User user);

    List<ExpenseUser> findAllByExpenses(List<Expense> expenses);
}
