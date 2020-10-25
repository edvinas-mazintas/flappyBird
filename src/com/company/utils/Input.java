package com.company.utils;

import com.company.Game;
import com.company.managers.PlayerManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

    private final Game game;

    public Input(Game game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            PlayerManager.getInstance().getPlayer().jump();
        }

        if (key == KeyEvent.VK_ENTER) {
            game.getTitleScene().setStarting(true);
            System.out.println("Pressed enter");
        }

        if (key == KeyEvent.VK_R) {
            game.getGameOverScene().setStarting(true);
            System.out.println("Pressed R");
        }
    }
}
