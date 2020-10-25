package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Sprite;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Ground extends GameObject {

    private Sprite sprite;
    private final Vector2 sizeOfSprite = new Vector2(0, 0);
    private final Rectangle boundingBox;

    public Ground(Vector2 position, GameObjectType type) {
        super(position, type);
        try {
            sprite = new Sprite("./resources/base.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sizeOfSprite.setX(sprite.getWidth());
        sizeOfSprite.setY(sprite.getHeight());
        boundingBox = new Rectangle(gameObjectPosition.getX(), gameObjectPosition.getY(), sizeOfSprite.getX(), sizeOfSprite.getY());
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

        int x = gameObjectPosition.getX();
        x -= 2;
        gameObjectPosition.setX(x);
    }
}
