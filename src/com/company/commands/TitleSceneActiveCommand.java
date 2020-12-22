package com.company.commands;

import com.company.interfaces.Command;
import com.company.scenes.TitleScene;

public class TitleSceneActiveCommand implements Command {
    private final TitleScene titleScene;

    public TitleSceneActiveCommand(TitleScene titleScene) {
        this.titleScene = titleScene;
    }

    @Override
    public void execute() {
        titleScene.setActive(true);
    }
}
