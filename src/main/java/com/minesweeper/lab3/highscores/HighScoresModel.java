package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.db.*;
import com.minesweeper.lab3.highscores.observer.HighScoresObservable;

import java.util.List;

public class HighScoresModel extends HighScoresObservable {
    private Settings settings;
    private List<Scores> highScores;

    public HighScoresModel(){

    }

    @Override
    public List<Scores> getHighScores() {
        return highScores;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    public void downloadAnotherHighScores(Settings settings) {
        this.settings = settings;
        HighScoresDB db = new FileHighScoresDB(settings);
        highScores = db.downloadHighScores().stream().toList();
        notifyObservers();
    }

    public void start() {
        SettingsDB db = new FileSettingsDB();
        downloadAnotherHighScores(db.downloadSettings());
    }
}
