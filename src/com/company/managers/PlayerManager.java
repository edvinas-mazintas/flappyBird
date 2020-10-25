package com.company.managers;

import com.company.gameobjects.Bird;

public class PlayerManager {
    private static PlayerManager instance = null;
    private Bird player = null;

    private PlayerManager() {
    }

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }

        return instance;
    }

    public Bird getPlayer() {
        return player;
    }

    public void setPlayer(Bird player) {
        this.player = player;
    }
}
