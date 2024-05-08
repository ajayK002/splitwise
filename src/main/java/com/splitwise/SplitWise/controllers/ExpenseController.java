package com.splitwise.SplitWise.controllers;

import com.splitwise.SplitWise.dtos.SettleUpGroupResponseDto;
import com.splitwise.SplitWise.dtos.SettleUpUserResponseDto;
import com.splitwise.SplitWise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    public SettleUpUserResponseDto settleUpUser(Long userId) throws Exception {
        return expenseService.settleUpUser(userId);
    }

    public SettleUpGroupResponseDto settleUpGroup(Long userId, Long groupId) {
        return expenseService.settleUpGroup(userId,groupId);
    }
}
