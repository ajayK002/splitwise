package com.splitwise.SplitWise.commands;

public interface Command {
    public boolean matches(String inputs);
    public void execute(String inputs) throws Exception;
}
