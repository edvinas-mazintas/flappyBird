package com.company.gameobjects;

import com.company.enums.GameObjectType;
import com.company.utils.Vector2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PipeTest {

    Pipe pipe = new Pipe(new Vector2(0,0), GameObjectType.PIPE, false);
    @Test
    @DisplayName("Bounding box position equals to sprite position")
    void update() {
        pipe.update();
        assertTrue(pipe.gameObjectPosition.getX() == pipe.getBoundingBox().x);
        assertTrue(pipe.gameObjectPosition.getY() == pipe.getBoundingBox().y);
    }
}