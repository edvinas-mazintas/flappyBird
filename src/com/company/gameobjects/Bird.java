package com.company.gameobjects;

import com.company.utils.Sprite;
import com.company.enums.GameObjectType;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Bird extends GameObject {
    private final int maxHeight;
    private final Rectangle boundingBox;
    double gravity = 0.2;
    double verticalSpeed = 0;
    private Sprite sprite;

    public Bird(Vector2 position, GameObjectType type) {
        super(position, type);

        try {
            sprite = new Sprite("./resources/bird.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        boundingBox = new Rectangle(gameObjectPosition.getX(), gameObjectPosition.getY(), sprite.getWidth(), sprite.getHeight());
        maxHeight = 50;
    }

    public void setVerticalSpeed(double verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite.getImage(), gameObjectPosition.getX(), gameObjectPosition.getY(), null);
    }

    @Override
    public void update() {

        boundingBox.x = gameObjectPosition.getX();
        boundingBox.y = gameObjectPosition.getY();

        gravity();
    }

    public void jump() {
        if (gameObjectPosition.getY() > maxHeight) {
            verticalSpeed -= 8;
        }
    }

    private void gravity() {
        verticalSpeed += gravity;

        if (verticalSpeed >= 6) {
            verticalSpeed = 6;
        }

        if (verticalSpeed <= -4) {
            verticalSpeed = -4;
        }

        int y = gameObjectPosition.getY();
        y += verticalSpeed;

        gameObjectPosition.setY(y);

    }
}
