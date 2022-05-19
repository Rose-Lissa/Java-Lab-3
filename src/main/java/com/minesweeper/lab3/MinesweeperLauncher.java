package com.minesweeper.lab3;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.game.GameService;
import com.minesweeper.lab3.highscores.HighScoresService;
import com.minesweeper.lab3.mainmenu.MainMenuService;
import com.minesweeper.lab3.settings.SettingsService;

import javax.swing.*;

public class MinesweeperLauncher {
    MinesweeperLauncher(Service.UI type){
        this.uiType = type;
        if(uiType == Service.UI.Console){
            ConsoleView.resetScreen();
        } else if(uiType == Service.UI.Graphic){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException |
                    UnsupportedLookAndFeelException |
                    IllegalAccessException |
                    InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public void startNewGame() {
        curService = new GameService(this, uiType);
        curService.start();
    }


    public void showHighScores() {
        curService = new HighScoresService(this, uiType);
        curService.start();
    }

    public void showSettings() {
        curService = new SettingsService(this, uiType);
        curService.start();
    }

    public void toMainMenu() {
        curService = new MainMenuService(this, uiType);
        curService.start();
    }

    public void exit() {

    }

    private Service curService;
    private Service.UI uiType;
}
