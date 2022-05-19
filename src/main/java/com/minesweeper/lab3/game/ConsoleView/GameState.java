package com.minesweeper.lab3.game.ConsoleView;

import com.minesweeper.lab3.consoleview.utility.actions.*;
import com.minesweeper.lab3.game.Cells;
import com.minesweeper.lab3.game.GameController;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameState extends ConsoleGameViewState {
    private final ActionsExecutor executor;

    GameState(ConsoleGameView view){
        super(view);
        executor = new ActionsExecutor.Builder()
                .addAction(new InputToStep((x, y) -> view.controller.setStep(x, y)))
                .addAction(new InputToAddFlag(((x, y) -> view.controller.setFlag(x, y))))
                .addAction(new InputToDelFlag(((x, y) -> view.controller.deleteFlag(x, y))))
                .addAction(new InputToExit(() -> view.controller.closeGame())).build();
    }

    @Override
    public void drawUI(List<Cells> field, PrintWriter writer) {
        drawField(field);
    }

    @Override
    public void readUserInput(Scanner reader) {
        waitingStep(reader);
    }

    private void waitingStep(Scanner reader){
        String userInput;
        do {
            userInput = view.reader.nextLine();
        } while(!executor.parseUserInput(userInput));
    }
}

