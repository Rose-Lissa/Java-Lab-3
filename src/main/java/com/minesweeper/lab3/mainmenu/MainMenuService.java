package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.MinesweeperLauncher;
import com.minesweeper.lab3.Service;

public class MainMenuService implements Service {
    private final MainMenuModel model;
    private final MainMenuController controller;
    private final MinesweeperLauncher launcher;
    private  MainMenuView view;

    public MainMenuService(MinesweeperLauncher minesweeperLauncher, UI type){
        this.launcher = minesweeperLauncher;
        model = new MainMenuModel();
        controller = new MainMenuController(this, model);
        buildUI(type);
    }

    private void buildUI(UI type){
        if(type == UI.Console)
            view = new ConsoleMainMenuView(model, controller);
        else if(type == UI.Graphic)
            view = new GraphicMainMenuView(model, controller);
    }

    public void goTo(MenuOptions options){
        view.hide();

        switch (options){
            case NEW_GAME -> launcher.startNewGame();
            case HIGH_SCORES -> launcher.showHighScores();
            case SETTINGS -> launcher.showSettings();
            case EXIT -> launcher.exit();
        }
    }

    @Override
    public void start() {
        model.startMainMenu();
        view.show();
    }
}
