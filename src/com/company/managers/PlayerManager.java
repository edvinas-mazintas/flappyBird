package com.company.managers;

import com.company.gameobjects.Player;

public class PlayerManager {
    private static PlayerManager instance = null;
    private Player player = null;

    private PlayerManager() {
    }

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }

        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
