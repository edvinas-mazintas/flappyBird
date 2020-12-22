package com.company;

import com.company.enums.State;
import com.company.scenes.GameOverScene;
import com.company.scenes.GameScene;
import com.company.scenes.TitleScene;
import com.company.utils.Input;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private Thread thread;
    private State currentState = State.STATE_TITLE;
    private boolean running = false;
    private GameScene gameScene;
    private TitleScene titleScene;
    private GameOverScene gameOverScene;


    public Game(int width, int height) {
        new Window(width, height, this);
    }

    public TitleScene getTitleScene() {
        return titleScene;
    }

    public GameOverScene getGameOverScene() {
        return gameOverScene;
    }

    @Override
    public void run() {
        init();
        this.addKeyListener(new Input(this));

        long lastTime = System.nanoTime();
        final double tickRate = 60.0;
        double ns = 1000000000 / tickRate;
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                update();
                delta--;
            }

            render();
        }
        stop();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.run();
    }

    private void init() {
        gameScene = new GameScene();
        titleScene = new TitleScene();
        gameOverScene = new GameOverScene();

        gameScene.init();
        titleScene.init();
        gameOverScene.init();
    }

    public void stop() {

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running = false;
    }


    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        switch (currentState) {
            case STATE_TITLE:
                titleScene.render(g);
                break;
            case STATE_GAME:
                gameScene.render(g);
                break;
            case STATE_GAME_OVER:
                gameOverScene.render(g);
                break;
        }

        g.dispose();
        bs.show();
    }

    private void update() {
        switch (currentState) {
            case STATE_TITLE:
                titleScene.update();

                if (titleScene.isActive()) {
                    currentState = State.STATE_GAME;
                }
                break;
            case STATE_GAME:
                gameScene.update();

                if (gameScene.isActive()) {
                    currentState = State.STATE_GAME_OVER;
                }

                break;
            case STATE_GAME_OVER:
                gameScene.setActive(false);
                gameScene.reset();
                gameOverScene.update();

                if (gameOverScene.isActive()) {
                    gameOverScene.setActive(false);
                    titleScene.setActive(false);
                    currentState = State.STATE_TITLE;
                }
                break;
        }
    }
}