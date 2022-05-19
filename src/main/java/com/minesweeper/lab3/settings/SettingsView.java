package com.minesweeper.lab3.settings;

import com.minesweeper.lab3.Observer;

public interface SettingsView extends Observer {
    void show();
    void hide();
}
