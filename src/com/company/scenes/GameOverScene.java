package com.company.scenes;

import com.company.enums.GameObjectType;
import com.company.gameobjects.Background;
import com.company.gameobjects.GameObject;
import com.company.gameobjects.GameOver;
import com.company.utils.Vector2;

import java.awt.*;
import java.util.ArrayList;

public class GameOverScene extends Scene {
    private final ArrayList<GameObject> gameObjects = new ArrayList<>();
    private boolean isStarting = false;

    @Override
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    @Override
    public void render(Graphics g) {
        gameObjects.forEach(gameObject -> gameObject.render(g));
    }

    @Override
    public void init() {
        gameObjects.add(new Background(new Vector2(0, 0), GameObjectType.BACKGROUND));
        gameObjects.add(new GameOver(new Vector2(45, 90), GameObjectType.BACKGROUND));
    }

    @Override
    public boolean isStarting() {
        return isStarting;
    }

    public void setStarting(boolean starting) {
        isStarting = starting;
    }

}
