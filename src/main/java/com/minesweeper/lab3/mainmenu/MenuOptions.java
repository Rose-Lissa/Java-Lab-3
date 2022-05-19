package com.minesweeper.lab3.mainmenu;

public enum MenuOptions {
    NEW_GAME,
    HIGH_SCORES,
    SETTINGS,
    EXIT;


    public static String menuOptionsToString(MenuOptions option) {
        return switch (option) {
            case NEW_GAME -> "New game";
            case SETTINGS -> "Settings";
            case EXIT -> "Exit";
            case HIGH_SCORES -> "High scores";
        };
    }
}
