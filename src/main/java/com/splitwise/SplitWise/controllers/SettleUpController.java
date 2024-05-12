package com.splitwise.SplitWise.controllers;

import com.splitwise.SplitWise.dtos.SettleUpGroupResponseDto;
import com.splitwise.SplitWise.dtos.SettleUpUserResponseDto;
import com.splitwise.SplitWise.services.SettleUpService;
import com.splitwise.SplitWise.services.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    @Autowired
    private SettleUpService settleUpService;
    public SettleUpUserResponseDto settleUpUser(Long userId) throws Exception {
        List<Transaction> transactions = settleUpService.settleUpUser(userId);

        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();
        responseDto.setTransactions(transactions);

        return responseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(Long userId, Long groupId) {
        return settleUpService.settleUpGroup(userId,groupId);
    }
}
