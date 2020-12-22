package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Vector2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player(new Vector2(50,100), GameObjectType.PLAYER);

    @Test
    @DisplayName("Sequential jumps do not exceed max player velocity")
    void jump() {
        for (int i = 0; i < 4; i++) {
            player.jump();
        }
        player.update();

        assertTrue(player.getVerticalVelocity() <= player.getVerticalVelocityMin());
    }

    @Test
    @DisplayName("Falling does not exceed max player velocity")
    void falling() {
        for (int i = 0; i < 60; i++) {
            player.update();
        }

        assertTrue(player.getVerticalVelocity() <= player.getVerticalVelocityMax());
    }
}