package com.splitwise.SplitWise.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    @Autowired
    public CommandExecutor(SettleUpUserCommand settleUpUserCommand, RegisterUserCommand registerUserCommand){
        commands.add(settleUpUserCommand);
        commands.add(registerUserCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String inputs) throws Exception {
        for (Command command : commands){
            if(command.matches(inputs)){
                System.out.println("inside " + command);
                command.execute(inputs);
            }
        }
    }
}
