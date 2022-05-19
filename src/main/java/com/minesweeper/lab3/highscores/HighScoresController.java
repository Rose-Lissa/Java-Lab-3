package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.db.Settings;

public class HighScoresController {
    private final HighScoresService service;
    private final HighScoresModel model;

    public HighScoresController(HighScoresService service, HighScoresModel model){
        this.service = service;
        this.model = model;
    }

    void downloadAnotherHighScores(Settings settings){
        model.downloadAnotherHighScores(settings);
    }

    void goToMainMenu() {
        service.goToMainMenu();
    }
}
