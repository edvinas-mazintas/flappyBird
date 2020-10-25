package com.company.managers;

import com.company.gameobjects.GameObject;

import java.util.ArrayList;

public class GameObjectManager {

    private static GameObjectManager instance = null;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private GameObjectManager() {};

    public static GameObjectManager getInstance(){
        if(instance == null){
            instance = new GameObjectManager();
        }

        return instance;
    }

    public void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        gameObjects.removeIf(o -> o.getID() == gameObject.getID());
    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
