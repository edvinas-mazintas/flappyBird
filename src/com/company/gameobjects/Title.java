package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Sprite;
import com.company.utils.Vector2;

import java.awt.*;
import java.io.IOException;

public class Title extends GameObject {
    private Sprite sprite;

    public Title(Vector2 position, GameObjectType type) {
        super(position, type);
        try {
            sprite = new Sprite("./resources/message.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite.getImage(), gameObjectPosition.getX(), gameObjectPosition.getY(), null);
    }

    @Override
    public void update() {

    }
}
