package com.minesweeper.lab3.mainmenu;

import com.minesweeper.lab3.mainmenu.observer.MainMenuObservable;

import java.util.ArrayList;
import java.util.List;

public class MainMenuModel extends MainMenuObservable {
    public MainMenuModel(){
        options = new ArrayList<>();
        options.add(MenuOptions.NEW_GAME);
        options.add(MenuOptions.HIGH_SCORES);
        options.add(MenuOptions.SETTINGS);
        options.add(MenuOptions.EXIT);
    }

    public void startMainMenu(){
        notifyObservers();
    }

    public List<MenuOptions> getOptions() {
        return options;
    }

    private List<MenuOptions> options;
}
