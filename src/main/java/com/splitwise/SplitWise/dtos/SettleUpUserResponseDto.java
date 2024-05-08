package com.splitwise.SplitWise.dtos;

import com.splitwise.SplitWise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Expense> expenseList;
}
