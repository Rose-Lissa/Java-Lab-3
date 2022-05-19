package com.minesweeper.lab3.game;

import com.minesweeper.lab3.MinesweeperLauncher;
import com.minesweeper.lab3.Service;
import com.minesweeper.lab3.game.ConsoleView.ConsoleGameView;

public class GameService implements Service {
    private final GameModel model;
    private final GameController controller;
    private final MinesweeperLauncher launcher;
    private GameView view;

    public GameService(MinesweeperLauncher launcher, UI type){
        this.launcher = launcher;
        model = new GameModel();
        controller = new GameController(this, model);
        buildUI(type);
    }

    public void start(){
        model.newGame();
        view.show();
    }

    private void buildUI(UI type){
        view = new ConsoleGameView(model, controller);
        //TODO change UI
    }

    public void exitToMainMenu() {
        view.hide();
        launcher.toMainMenu();
    }


}
