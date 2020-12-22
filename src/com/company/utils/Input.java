package com.company.utils;

import com.company.Game;
import com.company.commands.*;
import com.company.gameobjects.Player;
import com.company.managers.PlayerManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

    private final Game game;
    private final CommandExecutor commandExecutor = new CommandExecutor();
    private final Player player = PlayerManager.getInstance().getPlayer();

    public Input(Game game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            commandExecutor.execute(new ExitCommand());
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            commandExecutor.execute(new PlayerJumpCommand(player));
        }

        if (key == KeyEvent.VK_ENTER) {
            TitleSceneActiveCommand command = new TitleSceneActiveCommand(game.getTitleScene());
            commandExecutor.execute(command);
        }

        if (key == KeyEvent.VK_R) {
            GameOverActiveStartingCommand command = new GameOverActiveStartingCommand(game.getGameOverScene());
            commandExecutor.execute(command);
        }
    }
}
