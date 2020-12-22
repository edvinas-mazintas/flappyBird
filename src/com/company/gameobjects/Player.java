package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Sprite;
import com.company.utils.Utils;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Player extends GameObject {
    static final double GRAVITY_CONSTANT = 0.2;
    private final int maxYPosition;
    private final Rectangle boundingBox;
    private final int jumpVelocity = 8;
    double verticalVelocity = 0;
    private final double verticalVelocityMin = -4;
    private final double verticalVelocityMax = 6;
    private Sprite sprite;

    public Player(Vector2 position, GameObjectType type) {
        super(position, type);

        loadSprite();

        boundingBox = new Rectangle(gameObjectPosition.getX(), gameObjectPosition.getY(), sprite.getWidth(), sprite.getHeight());
        maxYPosition = 50;
    }

    public double getVerticalVelocity() {
        return verticalVelocity;
    }

    public void setVerticalVelocity(double verticalVelocity) {
        this.verticalVelocity = verticalVelocity;
    }

    public double getVerticalVelocityMin() {
        return verticalVelocityMin;
    }

    public double getVerticalVelocityMax() {
        return verticalVelocityMax;
    }

    private void loadSprite() {
        try {
            sprite = new Sprite("./resources/bird.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean intersects(Rectangle r) {
        return boundingBox.intersects(r);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite.getImage(), gameObjectPosition.getX(), gameObjectPosition.getY(), null);
    }

    @Override
    public void update() {
        boundingBox.x = gameObjectPosition.getX();
        boundingBox.y = gameObjectPosition.getY();
        applyGravity();
        move();
    }

    public void jump() {
        if (gameObjectPosition.getY() > maxYPosition) {
            this.verticalVelocity -= jumpVelocity;
        }
    }

    private void applyGravity() {
        verticalVelocity += GRAVITY_CONSTANT;
        limitVelocity(verticalVelocityMin, verticalVelocityMax);
    }

    private void move() {
        int y = gameObjectPosition.getY();
        y += verticalVelocity;
        gameObjectPosition.setY(y);
    }

    private void limitVelocity(double verticalVelocityMin, double verticalVelocityMax) {
        if (verticalVelocity >= verticalVelocityMax) {
            verticalVelocity = verticalVelocityMax;
        }

        if (verticalVelocity <= verticalVelocityMin) {
            verticalVelocity = verticalVelocityMin;
        }
    }
}
