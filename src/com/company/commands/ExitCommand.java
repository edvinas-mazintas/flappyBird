package com.company.commands;

import com.company.interfaces.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.exit(1);
    }
}
