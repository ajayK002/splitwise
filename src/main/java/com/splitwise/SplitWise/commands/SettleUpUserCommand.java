package com.splitwise.SplitWise.commands;

import com.splitwise.SplitWise.controllers.ExpenseController;
import com.splitwise.SplitWise.dtos.SettleUpGroupRequestDto;
import com.splitwise.SplitWise.dtos.SettleUpGroupResponseDto;
import com.splitwise.SplitWise.dtos.SettleUpUserRequestDto;
import com.splitwise.SplitWise.dtos.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {

    @Autowired
    ExpenseController expenseController;

    @Override
    public boolean matches(String inputs) {
        List<String> inputWords = List.of(inputs.split(" "));
        return inputWords.get(0).equals(CommandKeywords.commandKeyWord) &&
                inputWords.size() == 2;
    }

    @Override
    public void execute(String inputs) throws Exception {
        List<String> inputWords = List.of(inputs.split(" "));
        Long userId = Long.getLong(inputWords.get(0));

        SettleUpUserRequestDto settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);

        if (inputWords.size() == 2) {
            SettleUpUserResponseDto settleUpUserResponseDto = expenseController.settleUpUser(userId);
        } else if (inputWords.size() == 3) {         //if input contains group id also, that means have to settle up group
            Long groupId = Long.getLong(inputWords.get(2));

            SettleUpGroupRequestDto settleUpGroupRequestDto = new SettleUpGroupRequestDto();
            settleUpGroupRequestDto.setGroupId(groupId);

            SettleUpGroupResponseDto settleUpGroupResponseDto = expenseController.settleUpGroup(userId, groupId);
        }
    }
}
