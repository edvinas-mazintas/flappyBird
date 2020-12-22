package com.company.managers;

import com.company.enums.GameObjectType;
import com.company.gameobjects.GameObject;
import com.company.gameobjects.Pipe;
import com.company.utils.Utils;
import com.company.utils.Vector2;

import java.util.ArrayList;

public class PipeSpawner {

    ArrayList<GameObject> gameObjects;

    boolean isRunning = true;

    public PipeSpawner(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void run(int delay) {

        if (isRunning) {
            if (delay % (60 * 2) == 0) {

                int pipeLocationX = Utils.getRandomIntInRange(300, 400);
                int pipeUpsideDownLocationY = Utils.getRandomIntInRange(-250, -150);
                int pipeLocationY = Utils.getRandomIntInRange(250, 350);

                Pipe pipe = new Pipe(new Vector2(pipeLocationX, pipeUpsideDownLocationY), GameObjectType.PIPE, true);
                Pipe pipe2 = new Pipe(new Vector2(pipeLocationX, pipeLocationY), GameObjectType.PIPE, false);

                gameObjects.add(pipe);
                gameObjects.add(pipe2);
            }
        }
    }
}
