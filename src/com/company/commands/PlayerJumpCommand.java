package com.company.commands;

import com.company.gameobjects.Player;
import com.company.interfaces.Command;

public class PlayerJumpCommand implements Command {

    private final Player player;

    public PlayerJumpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.jump();
    }
}
