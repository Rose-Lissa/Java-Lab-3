package com.minesweeper.lab3.db;

public interface SettingsDB {
    String DEFAULT_USER_NAME = "player";
    int DEFAULT_SIZE_X = 9;
    int DEFAULT_SIZE_Y = 9;
    int DEFAULT_NUM_BOMB = 10;

    Settings downloadSettings();
    void saveSettings(Settings settings);
}
