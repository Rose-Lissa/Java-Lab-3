package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.MinesweeperLauncher;
import com.minesweeper.lab3.Service;

public class HighScoresService implements Service {
    private final MinesweeperLauncher launcher;
    private final HighScoresModel model;
    private final HighScoresController controller;
    private HighScoresView view;

    public HighScoresService(MinesweeperLauncher launcher, UI type){
        this.launcher = launcher;
        model = new HighScoresModel();
        controller = new HighScoresController(this, model);
        buildUI(type);
    }

    private void buildUI(UI type){
        if(type == UI.Console)
            view = new ConsoleHighScoresView(model, controller);
        else if(type == UI.Graphic)
            view = new GraphicHighScoresView(model, controller);
    }

    @Override
    public void start() {
        model.start();
        view.show();
    }

    public void goToMainMenu() {
        view.hide();
        launcher.toMainMenu();
    }
}
