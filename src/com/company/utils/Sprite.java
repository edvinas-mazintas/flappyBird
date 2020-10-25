package com.company.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private BufferedImage image;
    private final Vector2 spriteSize = new Vector2(0, 0);
    private final String pathName;

    public Sprite(String pathName) throws IOException {
        this.pathName = pathName;
        image = ImageIO.read(new File(pathName));
        assignSpriteSize();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return spriteSize.getX();
    }

    public int getHeight() {
        return spriteSize.getY();
    }

    private void assignSpriteSize() {
        spriteSize.setX(image.getWidth());
        spriteSize.setY(image.getHeight());
    }

}
