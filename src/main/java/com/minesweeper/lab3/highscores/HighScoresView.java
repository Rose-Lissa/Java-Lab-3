package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.Observer;

public interface HighScoresView extends Observer {
    void show();
    void hide();
}
