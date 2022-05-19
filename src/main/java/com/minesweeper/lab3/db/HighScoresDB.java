package com.minesweeper.lab3.db;

import java.util.Set;

public interface HighScoresDB {
    int MAX_NUM_SCORES = 10;
    void saveScores(Scores scores);
    Set<Scores> downloadHighScores();
}
