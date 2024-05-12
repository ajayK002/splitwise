package com.splitwise.SplitWise.services;

import com.splitwise.SplitWise.dtos.SettleUpGroupResponseDto;
import com.splitwise.SplitWise.dtos.SettleUpUserResponseDto;
import com.splitwise.SplitWise.models.Expense;
import com.splitwise.SplitWise.models.ExpenseUser;
import com.splitwise.SplitWise.models.User;
import com.splitwise.SplitWise.repositories.ExpenseUserRepository;
import com.splitwise.SplitWise.repositories.UserRepository;
import com.splitwise.SplitWise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExpenseUserRepository expenseUserRepository;

    @Autowired
    SettleUpStrategy settleUpStrategy;

    public List<Transaction> settleUpUser(Long userId) throws Exception {

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new Exception();
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

//        List<Expense> expenses = new ArrayList<>();
        List<Expense> expenses = new ArrayList<>();

        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);

        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }
        return null;
    }

    public SettleUpGroupResponseDto settleUpGroup(Long userId, Long groupId) {
        return null;
    }
}
