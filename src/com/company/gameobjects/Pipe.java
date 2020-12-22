package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Sprite;
import com.company.utils.Utils;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Pipe extends GameObject{

    private final Vector2 sizeOfSprite = new Vector2(0, 0);
    private final boolean isUpsideDown;
    private final Rectangle boundingBox;
    private Sprite sprite;

    public Pipe(Vector2 position, GameObjectType type, boolean isUpsideDown) {
        super(position, type);
        this.isUpsideDown = isUpsideDown;

        loadSprite();
        setSpriteSize();

        if (this.isUpsideDown) {
            sprite.setImage(Utils.rotateImageByDegrees(sprite.getImage(), 180));
        }

        boundingBox = new Rectangle(gameObjectPosition.getX(), gameObjectPosition.getY(), sizeOfSprite.getX(), sizeOfSprite.getY());
    }

    private void setSpriteSize() {
        sizeOfSprite.setX(sprite.getWidth());
        sizeOfSprite.setY(sprite.getHeight());
    }

    private void loadSprite() {
        try {
            sprite = new Sprite("./resources/pipe-green.png");
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
        gameObjectPosition.setX(gameObjectPosition.getX() - 2);
        boundingBox.x = gameObjectPosition.getX();
        boundingBox.y = gameObjectPosition.getY();
    }
}
