package com.company.gameobjects;


import com.company.enums.GameObjectType;
import com.company.utils.Vector2;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class GameObject {
    private static final AtomicInteger count = new AtomicInteger(0);
    public GameObjectType type;
    protected int ID;
    protected Vector2 gameObjectPosition;

    public GameObject(Vector2 position, GameObjectType type) {
        this.gameObjectPosition = position;
        this.ID = count.incrementAndGet();
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public Vector2 getGameObjectPosition() {
        return gameObjectPosition;
    }

    public void setGameObjectPosition(Vector2 gameObjectPosition) {
        this.gameObjectPosition = gameObjectPosition;
    }

    abstract public void render(Graphics g);
    abstract public void update();
}
