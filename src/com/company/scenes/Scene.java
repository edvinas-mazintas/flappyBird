package com.company.scenes;

import java.awt.*;

public abstract class Scene {
    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void init();

    public abstract boolean isStarting();
}
