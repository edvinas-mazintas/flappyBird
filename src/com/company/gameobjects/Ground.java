package com.company.gameobjects;
import com.company.enums.GameObjectType;
import com.company.utils.Sprite;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Ground extends GameObject{

    private Sprite sprite;
    private final Vector2 sizeOfSprite = new Vector2(0, 0);
    private final Rectangle boundingBox;

    public Ground(Vector2 position, GameObjectType type) {
        super(position, type);
        loadSprite();
        setSpriteSize();

        boundingBox = new Rectangle(gameObjectPosition.getX(), gameObjectPosition.getY(), sizeOfSprite.getX(), sizeOfSprite.getY());
    }

    private void setSpriteSize() {
        sizeOfSprite.setX(sprite.getWidth());
        sizeOfSprite.setY(sprite.getHeight());
    }

    private void loadSprite() {
        try {
            sprite = new Sprite("./resources/base.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        updateBoundingBoxLocation();
        move();
    }

    private void updateBoundingBoxLocation() {
        boundingBox.x = gameObjectPosition.getX();
        boundingBox.y = gameObjectPosition.getY();
    }

    private void move() {
        gameObjectPosition.setX(gameObjectPosition.getX() - 2);
    }
}
