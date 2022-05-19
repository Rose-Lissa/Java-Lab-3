package com.minesweeper.lab3.game;

import com.minesweeper.lab3.db.*;
import com.minesweeper.lab3.game.field.BackgroundField;
import com.minesweeper.lab3.game.field.ForegroundField;
import com.minesweeper.lab3.game.observer.GameObservable;

import java.util.List;

public class GameModel extends GameObservable {
    GameModel() {
    }

    public void newGame() {
        downloadSettings();
        timer = new GameTimer(this);

        foregroundField = new ForegroundField(sizeX, sizeY);
        foregroundField.generateField();

        backgroundField = new BackgroundField(sizeX, sizeY, numBomb);
        backgroundField.generateField();

        curState = State.GAME;

        timeThread = new Thread(timer);
        timeThread.start();

        notifyObservers();
    }

    private void downloadSettings(){
        SettingsDB settingsDB = new FileSettingsDB();
        settings = settingsDB.downloadSettings();
        sizeX = settings.getSizeX();
        sizeY = settings.getSizeY();
        numBomb = settings.getNumBomb();
    }

    public void setStep(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            Cells openedCell = backgroundField.getCell(x, y);
            if (openedCell == Cells.BOMB) {
                foregroundField.copyField(backgroundField);
                lostGame();
                return;
            } else {
                foregroundField.setCell(x, y, openedCell);
                openZeroCells(x, y);
                if(isWinGame()){
                    winGame();
                    return;
                }
            }
        }
        notifyObservers();
    }

    private void openZeroCells(int x, int y){
        if(foregroundField.getCell(x, y) != Cells.EMPTY)
            return;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0)
                    continue;
                if((x+i) >= sizeX || (x+i) < 0)
                    continue;
                if((y+j) >= sizeY || (y+j) < 0)
                    continue;

                if(foregroundField.getCell(x+i, y+j) == Cells.UNKNOWN){
                    foregroundField.setCell(x+i, y+j, backgroundField.getCell(x+i, y+j));
                    openZeroCells(x + i, y + j);
                }
            }
        }

    }

    public void setFlag(int x, int y) {
        if(foregroundField.isUnknownCell(x, y)) {
            foregroundField.setCell(x, y, Cells.FLAG);
        }
        notifyObservers();
    }

    public void deleteFlag(int x, int y){
        if(foregroundField.getCell(x, y) == Cells.FLAG) {
            foregroundField.setCell(x, y, Cells.UNKNOWN);
        }
        notifyObservers();
    }

    public void lostGame()  {
        curState = State.LOST_GAME;
        endGame();
        notifyObservers();
    }

    public void winGame() {
        saveStatistics();
        curState = State.WIN_GAME;
        endGame();
        notifyObservers();
    }

    private void saveStatistics(){
        HighScoresDB scoresDB = new FileHighScoresDB(settings);
        scoresDB.saveScores(new Scores( settings.getUserName(), timePassed));
    }

    public void endGame(){
        timer.stop();
        try {
            timeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isWinGame() {
        for(int x = 0; x < sizeX; x++){
            for(int y = 0; y < sizeY; y++){
                if(foregroundField.isUnknownCell(x, y)
                        && backgroundField.getCell(x, y) != Cells.BOMB){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<Cells> getField(){
        return foregroundField.getField();
    }

    @Override
    public State getState() {
        return curState;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    public long getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(long timePassed) {
        this.timePassed = timePassed;
    }

    private int sizeX = 9;
    private int sizeY = 9;
    private int numBomb = 10;
    private long timePassed = 0;

    Settings settings;

    private GameTimer timer;
    Thread timeThread;
    private State curState;
    private BackgroundField backgroundField;
    private ForegroundField foregroundField;
}
