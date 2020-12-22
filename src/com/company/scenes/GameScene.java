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
    private Player player;
    private final ArrayList<GameObject> gameObjects = new ArrayList<>();
    private final GroundSpawner groundSpawner = new GroundSpawner(gameObjects);
    private final PipeSpawner pipeSpawner = new PipeSpawner(gameObjects);
    private int delay;
    private boolean isActive = false;

    public GameScene() {

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public void update() {
        gameObjects.forEach(o -> o.update());
        delay++;

        for (GameObject go : gameObjects) {
            if (go.type == GameObjectType.PIPE) {
                Pipe pipe = (Pipe) go;

                if(PlayerManager.getInstance().getPlayer().intersects(pipe.getBoundingBox())){
                    isActive = true;
                }
            }

            if (go.type == GameObjectType.GROUND) {
                Ground ground = (Ground) go;

                if(PlayerManager.getInstance().getPlayer().intersects(ground.getBoundingBox())){
                    isActive = true;
                }
            }
        }
        pipeSpawner.run(delay);
        groundSpawner.run();
    }

    @Override
    public void render(Graphics g) {
        gameObjects.forEach(o -> o.render(g));
    }

    @Override
    public void init() {
        player = new Player(new Vector2(50, 100), GameObjectType.PLAYER);
        PlayerManager.getInstance().setPlayer(player);

        gameObjects.add(new Background(new Vector2(0, 0), GameObjectType.BACKGROUND));
        gameObjects.add(player);

        groundSpawner.init();
    }

    public void reset() {
        player.setGameObjectPosition(new Vector2(50, 100));
        player.setVerticalVelocity(0);
        pipeSpawner.getGameObjects().removeIf(gameObject -> gameObject.type == GameObjectType.PIPE);
    }
}
