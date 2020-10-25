package com.company.scenes;

import com.company.enums.GameObjectType;
import com.company.gameobjects.*;
import com.company.managers.GroundSpawner;
import com.company.managers.PipeSpawner;
import com.company.managers.PlayerManager;
import com.company.utils.Vector2;

import java.awt.*;
import java.util.ArrayList;

public class GameScene extends Scene {
    Bird player;
    private final ArrayList<GameObject> gameObjects = new ArrayList<>();
    private final GroundSpawner gs = new GroundSpawner(gameObjects);
    private final PipeSpawner ps = new PipeSpawner(gameObjects);
    private int delay;
    private boolean gameOver = false;

    public GameScene() {

    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public void update() {
        gameObjects.forEach(o -> o.update());
        delay++;

        for (GameObject go : gameObjects) {
            if (go.type == GameObjectType.PIPE) {
                Pipe pipe = (Pipe) go;

                if (PlayerManager.getInstance().getPlayer().getBoundingBox().intersects(pipe.getBoundingBox())) {
                    gameOver = true;
                }
            }


            if (go.type == GameObjectType.GROUND) {
                Ground ground = (Ground) go;

                if (PlayerManager.getInstance().getPlayer().getBoundingBox().intersects(ground.getBoundingBox())) {
                    gameOver = true;
                }
            }
        }
        ps.run(delay);
        gs.run();
    }

    @Override
    public void render(Graphics g) {
        gameObjects.forEach(o -> o.render(g));
    }

    @Override
    public void init() {

        player = new Bird(new Vector2(50, 100), GameObjectType.PLAYER);
        gameObjects.add(new Background(new Vector2(0, 0), GameObjectType.BACKGROUND));
        gameObjects.add(player);

        PlayerManager.getInstance().setPlayer(player);

        gs.init();
    }

    public void reset() {
        player.setGameObjectPosition(new Vector2(50, 100));
        player.setVerticalSpeed(0);
        ps.getGameObjects().removeIf(gameObject -> gameObject.type == GameObjectType.PIPE);
    }

    @Override
    public boolean isStarting() {
        return true;
    }
}
