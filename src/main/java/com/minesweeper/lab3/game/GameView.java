package com.minesweeper.lab3.game;

import com.minesweeper.lab3.Observer;

public interface GameView extends Observer {
    void show();
    void hide();
}
