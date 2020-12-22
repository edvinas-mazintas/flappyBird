package com.company.commands;

import com.company.interfaces.Command;
import com.company.scenes.GameOverScene;

public class GameOverActiveStartingCommand implements Command {

    private final GameOverScene gameOverScene;

    public GameOverActiveStartingCommand(GameOverScene gameOverScene) {
        this.gameOverScene = gameOverScene;
    }

    @Override
    public void execute() {
        gameOverScene.setActive(true);
    }
}
