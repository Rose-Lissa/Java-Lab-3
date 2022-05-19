package com.minesweeper.lab3.highscores;

import com.minesweeper.lab3.consoleview.utility.ConsoleView;
import com.minesweeper.lab3.consoleview.utility.actions.ActionsExecutor;
import com.minesweeper.lab3.consoleview.utility.actions.InputToChangeSettings;
import com.minesweeper.lab3.consoleview.utility.actions.InputToExit;
import com.minesweeper.lab3.db.Scores;
import com.minesweeper.lab3.db.Settings;
import com.minesweeper.lab3.highscores.observer.HighScoresObservable;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleHighScoresView extends ConsoleView implements HighScoresView {
    private final HighScoresObservable observable;
    private final ActionsExecutor executor;
    Settings settings;
    private List<Scores> highScores;
    private final HighScoresController controller;

    public ConsoleHighScoresView(HighScoresObservable observable, HighScoresController controller){
        observable.registerObserver(this);
        this.observable = observable;
        this.controller = controller;

        executor = new ActionsExecutor.Builder()
                .addAction(new InputToChangeSettings((sizeX, sizeY, numBomb) -> {
                    settings.setSizeX(sizeX);
                    settings.setSizeY(sizeY);
                    settings.setNumBomb(numBomb);
                    controller.downloadAnotherHighScores(settings);
                }))
                .addAction(new InputToExit(controller::goToMainMenu))
                .build();
    }
    @Override
    public synchronized void draw(PrintWriter writer) {
        writer.println("HighScores: " + settings.getSizeX() + " x " + settings.getSizeY() + " num bomb: " + settings.getNumBomb());
        int i = 1;
        for(Scores scores: highScores){
            long minutesPassed = TimeUnit.MILLISECONDS.toMinutes(scores.getTime());
            long secondsPassed = TimeUnit.MILLISECONDS.toSeconds(scores.getTime()) - TimeUnit.MINUTES.toSeconds(minutesPassed);
            writer.println(i + ". " + scores.getUserName() + "\t\t" + minutesPassed + ":" + secondsPassed);
            i++;
        }
    }


    @Override
    public synchronized void read(Scanner reader) {
        String userInput;
        do{
            userInput = reader.nextLine();
        }while (!executor.parseUserInput(userInput));
    }

    @Override
    public void update() {
        this.settings = observable.getSettings();
        this.highScores = observable.getHighScores();
        redraw();
    }
}
