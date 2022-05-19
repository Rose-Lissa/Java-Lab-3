package com.minesweeper.lab3.highscores.observer;

import com.minesweeper.lab3.Observable;
import com.minesweeper.lab3.db.Scores;
import com.minesweeper.lab3.db.Settings;

import java.util.List;

public abstract class HighScoresObservable extends Observable {
    public abstract List<Scores> getHighScores();
    public abstract Settings getSettings();
}
