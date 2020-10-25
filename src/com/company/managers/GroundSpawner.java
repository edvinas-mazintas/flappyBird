package com.company.managers;

import com.company.gameobjects.GameObject;
import com.company.enums.GameObjectType;
import com.company.gameobjects.Ground;
import com.company.utils.Vector2;

import java.util.ArrayList;

public class GroundSpawner {

    ArrayList<GameObject> gameObjects;

    public GroundSpawner(ArrayList<GameObject> gameObjects){
        this.gameObjects = gameObjects;
    }

    private Ground firstGround = new Ground(new Vector2(0, 400), GameObjectType.GROUND);
    private Ground secondGround = new Ground(new Vector2(336, 400), GameObjectType.GROUND);


    public void init(){
        gameObjects.add(firstGround);
        gameObjects.add(secondGround);
    }


    public void run(){
        if(firstGround.getGameObjectPosition().getX() == -48){
            firstGround.setGameObjectPosition(new Vector2(0, 400));
        }

        if(secondGround.getGameObjectPosition().getX() == -48){
            secondGround.setGameObjectPosition(new Vector2(0, 400));
        }
    }
}
