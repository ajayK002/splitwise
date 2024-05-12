package com.splitwise.SplitWise.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateExpenseCommand implements Command{
    @Override
    public boolean matches(String inputs) {
        List<String> inputWords = List.of(inputs.split(" "));

        return false;
    }

    @Override
    public void execute(String inputs) throws Exception {

    }
}
