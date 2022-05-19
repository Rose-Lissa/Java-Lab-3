package com.minesweeper.lab3.settings.observer;

import com.minesweeper.lab3.Observable;
import com.minesweeper.lab3.db.Settings;

public abstract class SettingsObservable extends Observable {
    abstract public Settings getSettings();
}
