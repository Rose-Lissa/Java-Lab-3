package com.minesweeper.lab3.mainmenu.observer;

import com.minesweeper.lab3.Observable;
import com.minesweeper.lab3.mainmenu.MenuOptions;

import java.util.List;

public abstract class MainMenuObservable extends Observable {
    public abstract List<MenuOptions> getOptions();
}
