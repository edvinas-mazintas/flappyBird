package com.company.commands;

import com.company.interfaces.Command;

public class CommandExecutor {
    public void execute(Command command){
        command.execute();
    }
}
